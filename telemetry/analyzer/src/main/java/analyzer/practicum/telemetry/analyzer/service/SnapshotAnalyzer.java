package analyzer.practicum.telemetry.analyzer.service;

import analyzer.practicum.telemetry.analyzer.controller.ActionRequestProtoMapper;
import analyzer.practicum.telemetry.analyzer.controller.HubRouterController;
import analyzer.practicum.telemetry.analyzer.dal.model.Condition;
import analyzer.practicum.telemetry.analyzer.dal.model.Scenario;
import analyzer.practicum.telemetry.analyzer.dal.model.enumeration.ConditionType;
import analyzer.practicum.telemetry.analyzer.dal.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.grpc.telemetry.event.DeviceActionRequest;
import ru.yandex.practicum.kafka.telemetry.event.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SnapshotAnalyzer {
    private final ScenarioService scenarioService;
    private final HubRouterController hubRouterController;
    private final ActionRequestProtoMapper actionRequestProtoMapper;

    public void handleSnapshot(SensorsSnapshotAvro sensorsSnapshotAvro) {
        String hubId = sensorsSnapshotAvro.getHubId();
        Map<String, SensorStateAvro> states = sensorsSnapshotAvro.getSensorsState();
        List<Scenario> scenarios = scenarioService.getByHubId(hubId);
        scenarios.stream()
                .filter(scenario -> checkConditions(scenario, states))
                .forEach(this::executeActions);
    }

    private boolean checkConditions(Scenario scenario, Map<String, SensorStateAvro> states) {
        List<Condition> conditions = new ArrayList<>();
        Map<String, Condition> conditionsMap = scenario.getConditions();
        return conditionsMap.entrySet().stream().allMatch(entry -> evaluateCondition(entry.getKey(), entry.getValue(),states));
    }

    private boolean evaluateCondition(String sensorId, Condition condition, Map<String, SensorStateAvro> states) {
        SensorStateAvro state = states.get(condition.getSensorId());
        if (state == null) {
            return false;
        }

        Integer sensorValue = extractSensorValue(state.getData(), condition.getType());
        if (sensorValue == null) {
            return false;
        }

        return switch (condition.getOperation()) {
            case EQUALS -> sensorValue.equals(condition.getValue());
            case LOWER_THAN -> sensorValue < condition.getValue();
            case GREATER_THAN -> sensorValue > condition.getValue();
        };
    }

    private Integer extractSensorValue(Object data, ConditionType type) {
        return switch (type) {
            case TEMPERATURE -> data instanceof ClimateSensorAvro climate ? climate.getTemperatureC() : null;
            case HUMIDITY -> data instanceof ClimateSensorAvro climate ? climate.getHumidity() : null;
            case CO2LEVEL -> data instanceof ClimateSensorAvro climate ? climate.getCo2Level() : null;
            case LUMINOSITY -> data instanceof LightSensorAvro light ? light.getLuminosity() : null;
            case MOTION -> data instanceof MotionSensorAvro motion ? (motion.getMotion() ? 1 : 0) : null;
            case SWITCH -> data instanceof SwitchSensorAvro switchSensor ? (switchSensor.getState() ? 1 : 0) : null;
        };
    }

    private void executeActions(Scenario scenario) {
        List<DeviceActionRequest> requests = actionRequestProtoMapper.toActionRequest(scenario);
        requests.forEach(hubRouterController::sendAction);
    }
}

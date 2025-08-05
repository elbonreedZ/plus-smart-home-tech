package analyzer.practicum.telemetry.analyzer.dal.service;

import analyzer.practicum.telemetry.analyzer.dal.model.Scenario;
import analyzer.practicum.telemetry.analyzer.dal.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioRepository repository;
    private final ActionService actionService;
    private final ConditionService conditionService;

    @Transactional
    public void save(Scenario scenario) {
        scenario.getActions().values().stream().peek(actionService::save).close();
        scenario.getConditions().values().stream().peek(conditionService::save).close();
        repository.save(scenario);
    }

    public void remove(String name) {
        repository.deleteByName(name);
    }

    public List<Scenario> getByHubId(String hubId) {
        return repository.findByHubId(hubId);
    }
}

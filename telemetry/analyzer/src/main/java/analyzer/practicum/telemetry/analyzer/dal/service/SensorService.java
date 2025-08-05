package analyzer.practicum.telemetry.analyzer.dal.service;

import analyzer.practicum.telemetry.analyzer.dal.model.Sensor;
import analyzer.practicum.telemetry.analyzer.dal.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository repository;
    public void save(Sensor sensor) {
        repository.save(sensor);
    }

    public void remove(String id) {
        repository.deleteById(id);
    }
}

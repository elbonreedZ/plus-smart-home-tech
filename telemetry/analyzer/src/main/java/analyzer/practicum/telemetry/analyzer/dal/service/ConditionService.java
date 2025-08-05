package analyzer.practicum.telemetry.analyzer.dal.service;

import analyzer.practicum.telemetry.analyzer.dal.model.Condition;
import analyzer.practicum.telemetry.analyzer.dal.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConditionService {
    private final ConditionRepository repository;
    public void save(Condition condition) {
        repository.save(condition);
    }
}

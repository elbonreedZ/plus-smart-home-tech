package analyzer.practicum.telemetry.analyzer.dal.service;

import analyzer.practicum.telemetry.analyzer.dal.model.Action;
import analyzer.practicum.telemetry.analyzer.dal.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository repository;
    public void save(Action action) {
        repository.save(action);
    }
}

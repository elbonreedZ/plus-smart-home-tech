package analyzer.practicum.telemetry.analyzer.dal.repository;

import analyzer.practicum.telemetry.analyzer.dal.model.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
    List<Scenario> findByHubId(String hubId);

    Optional<Scenario> findByHubIdAndName(String hubId, String name);

    void deleteByName(String name);
}

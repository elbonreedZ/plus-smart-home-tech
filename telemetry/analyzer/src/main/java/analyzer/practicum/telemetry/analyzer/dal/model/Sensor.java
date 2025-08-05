package analyzer.practicum.telemetry.analyzer.dal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Sensor {
    @Id
    private String id;
    @Column(name = "hub_id")
    private String hubId;
}

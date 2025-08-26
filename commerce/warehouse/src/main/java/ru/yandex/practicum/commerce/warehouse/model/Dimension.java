package ru.yandex.practicum.commerce.warehouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Dimension {
    @Column(name = "dimension_width")
    private float width;
    @Column(name = "dimension_height")
    private float height;
    @Column(name = "dimension_depth")
    private float depth;
}

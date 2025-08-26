package ru.yandex.practicum.commerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DimensionDto {
    @NotNull
    private double width;
    @NotNull
    private double height;
    @NotNull
    private double depth;
}


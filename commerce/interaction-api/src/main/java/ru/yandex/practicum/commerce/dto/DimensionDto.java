package ru.yandex.practicum.commerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DimensionDto {
    @NotNull
    private Float width;
    @NotNull
    private Float height;
    @NotNull
    private Float depth;
}


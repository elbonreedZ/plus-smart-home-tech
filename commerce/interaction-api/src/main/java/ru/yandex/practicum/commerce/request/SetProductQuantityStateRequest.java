package ru.yandex.practicum.commerce.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.yandex.practicum.commerce.dto.QuantityState;

@Data
@AllArgsConstructor
public class SetProductQuantityStateRequest {
    private String productId;
    private QuantityState quantityState;
}

package ru.yandex.practicum.commerce.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.commerce.enums.OrderState;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class OrderDto {
    String orderId;
    String shoppingCartId;
    Map<String, Integer> products = new HashMap<>();
    String paymentId;
    String deliveryId;
    OrderState orderState;
    Float deliveryWeight;
    Float deliveryVolume;
    Boolean fragile;
    BigDecimal totalPrice;
    BigDecimal deliveryPrice;
    BigDecimal productPrice;
}


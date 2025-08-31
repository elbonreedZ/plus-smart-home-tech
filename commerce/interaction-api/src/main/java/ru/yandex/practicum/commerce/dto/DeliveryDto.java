package ru.yandex.practicum.commerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.commerce.enums.DeliveryState;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryDto {
    String deliveryId;
    @NotNull
    AddressDto fromAddress;
    @NotNull
    AddressDto toAddress;
    @NotBlank
    String orderId;
    DeliveryState deliveryState;
}

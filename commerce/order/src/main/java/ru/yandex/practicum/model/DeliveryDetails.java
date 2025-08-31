package ru.yandex.practicum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class DeliveryDetails {
    @Column(name = "delivery_id")
    String deliveryId;
    @Column(name = "delivery_weight")
    double deliveryWeight;
    @Column(name = "delivery_volume")
    double deliveryVolume;
    @Column(name = "delivery_fragile")
    boolean fragile;
    @Column(name = "delivery_price")
    BigDecimal deliveryPrice;
}

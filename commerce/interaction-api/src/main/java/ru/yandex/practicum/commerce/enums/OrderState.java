package ru.yandex.practicum.commerce.enums;

public enum OrderState {
    NEW,
    ON_PAYMENT,
    ON_DELIVERY,
    DELIVERED,
    ASSEMBLED,
    PAID,
    COMPLETED,
    DELIVERY_FAILED,
    ASSEMBLY_FAILED,
    PAYMENT_FAILED,
    PRODUCT_RETURNED,
    CANCELED
}

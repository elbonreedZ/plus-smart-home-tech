package ru.yandex.practicum.commerce.request;

import lombok.Data;

@Data
public class ChangeProductQuantityRequest {
    private String productId;
    private int newQuantity;
}

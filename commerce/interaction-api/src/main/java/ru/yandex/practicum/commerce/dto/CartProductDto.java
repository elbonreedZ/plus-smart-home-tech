package ru.yandex.practicum.commerce.dto;

import lombok.Data;

@Data
public class CartProductDto {
    private String productId;
    private int quantity;
}

package ru.yandex.practicum.commerce.cart.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_products", schema = "commerce_cart")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "quantity")
    private int quantity;
}

package ru.yandex.practicum.commerce.warehouse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order_booking", schema = "commerce_warehouse")
public class OrderBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "order_id")
    String orderId;
    @Column(name = "delivery_id")
    String deliveryId;
    @ElementCollection
    @CollectionTable(
            name = "order_booking_products",
            schema = "commerce_warehouse",
            joinColumns = @JoinColumn(name = "order_booking_id")
    )
    @MapKeyColumn(name = "product_code")
    @Column(name = "quantity")
    Map<String, Integer> products;
}

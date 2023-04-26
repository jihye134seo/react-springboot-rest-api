package com.example.orderapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "order_tb")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid", unique = true, nullable = false)
    Long oid;

    @Column(name = "total_price", nullable = false)
    Long totalPrice;

    @Column(name = "total_number", nullable = false)
    Long totalNumber;

    @Column(name = "created_time", nullable = false)
    LocalDateTime createdTime;
}

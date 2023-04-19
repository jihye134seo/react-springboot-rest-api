package com.example.orderapi.entity.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @Column(name = "oid", unique = true, nullable = false)
    Long oid;
    @Column(name = "total_price", nullable = false)
    Long totalPrice;
    @Column(name = "total_number", nullable = false)
    Long totalNumber;
    @Column(name = "created_time", nullable = false)
    LocalDateTime createdTime;
}

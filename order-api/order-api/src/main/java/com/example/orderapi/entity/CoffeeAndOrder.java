package com.example.orderapi.entity;

import com.example.productapi.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "coffee_and_order_tb")
@Builder
public class CoffeeAndOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caoid", unique = true, nullable = false)
    Long caoid;

    @OneToOne
    @JoinColumn(name="oid")
    Order oid;

    @OneToOne
    @JoinColumn(name="cid")
    Coffee cid;

    @Column(name = "count", nullable = false)
    Long count;
}

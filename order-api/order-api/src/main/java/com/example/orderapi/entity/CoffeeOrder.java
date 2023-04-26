package com.example.orderapi.entity;

import com.example.productapi.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "coffee_order")
@Builder
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coid", unique = true, nullable = false)
    Long coid;

    @OneToOne
    @JoinColumn(name="oid")
    Order oid;

    @OneToOne
    @JoinColumn(name="cid")
    Coffee cid;

    @Column(name = "count", nullable = false)
    Long count;
}

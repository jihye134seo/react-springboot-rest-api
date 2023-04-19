package com.example.orderapi.entity.client;

import com.example.productapi.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "coffee_and_order_tb")
public class CoffeeAndOrder {

    @Id
    @Column(name = "caoid", unique = true, nullable = false)
    Long caoid;

    @ManyToOne
    @JoinColumn(name="oid")
    Order oid;

    @ManyToOne
    @JoinColumn(name="cid")
    Coffee cid;

    @Column(name = "count", nullable = false)
    Long count;
}

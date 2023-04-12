package com.example.orderapi.entity.client;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "coffee")
public class Coffee {

    @Id
    @Column(name = "cid", unique = true, nullable = false)
    UUID cid;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "price", nullable = false)
    Long price;
    @Column(name = "origin", nullable = false)
    String origin;
    @Column(name = "producer", nullable = false)
    String producer;
    @Column(name = "created_time", nullable = false)
    LocalDateTime createdTime;

}

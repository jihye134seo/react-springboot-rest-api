package com.example.orderapi.entity.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoffeeInsertRequest {

    String name;
    Long price;
    String origin;
    String producer;

}

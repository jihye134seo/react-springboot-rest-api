package com.example.productapi.dto;

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

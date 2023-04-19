package com.example.orderapi.dto;


import com.example.orderapi.entity.CoffeeAndOrder;
import com.example.orderapi.entity.Order;
import com.example.productapi.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderGetResponse {

    Order order;
    Coffee coffee;
    Long count;

}

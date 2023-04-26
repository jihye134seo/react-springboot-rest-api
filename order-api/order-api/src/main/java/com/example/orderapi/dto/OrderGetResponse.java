package com.example.orderapi.dto;


import com.example.orderapi.entity.Order;
import com.example.productapi.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderGetResponse {

    Order order;
    Coffee coffee;
    Long count;

}

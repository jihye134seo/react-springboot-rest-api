package com.example.orderapi.controller;


import com.example.orderapi.dto.OrderGetResponse;
import com.example.orderapi.dto.OrderPostRequest;
import com.example.orderapi.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{oid}")
    public OrderGetResponse getOrderInfo(@PathVariable Long oid){
        return orderService.getOrderInfo(oid);
    }

    @PostMapping("")
    public String insertOrderInfo(@RequestBody OrderPostRequest orderPostRequest){
        return orderService.insertOrderInfo(orderPostRequest);
    }

    @DeleteMapping("/{oid}")
    public String deleteOrderInfo(@PathVariable Long oid){
        return orderService.deleteOrderInfo(oid);
    }



}

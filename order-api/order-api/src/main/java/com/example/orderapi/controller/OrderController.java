package com.example.orderapi.controller;


import com.example.orderapi.entity.client.*;
import com.example.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/order/{oid}")
    public String getOrderInfo(@PathVariable String oid){   //기능
//        return orderService.getOrderInfo(orderGetRequest);


        return "get";
    }

    @PostMapping(value = "/order")
    public String insertOrderInfo(@RequestBody OrderPostRequest orderPostRequest){
//        return orderService.insertOrderInfo(orderPostRequest);
        return "post";

    }

    @DeleteMapping(value = "/order/{oid}")
    public String deleteOrderInfo(@PathVariable String oid){
//        return orderService.deleteOrderInfo(orderDeleteRequest);
        return "DELETE";

    }



}

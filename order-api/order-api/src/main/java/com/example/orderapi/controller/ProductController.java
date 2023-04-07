package com.example.orderapi.controller;


import com.example.orderapi.entity.client.Coffee;
import com.example.orderapi.entity.client.CoffeeEditRequest;
import com.example.orderapi.entity.client.CoffeeInsertRequest;
import com.example.orderapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService ps;

    @GetMapping(value = "/product/coffee/{name}")
    public Coffee getCoffeeInfo(@PathVariable String name){   //기능
        return ps.getCoffeeInfo(name);
    }

    @PostMapping(value = "/product/coffee")
    public String insertCoffeeInfo(@RequestBody CoffeeInsertRequest coffeeInsertRequest){
        return ps.insertCoffeeInfo(coffeeInsertRequest);
    }

    @PutMapping(value = "/product/coffee")
    public String putCoffeeInfo(@RequestBody CoffeeEditRequest coffeeEditRequest){
        return ps.putCoffeeInfo(coffeeEditRequest);
    }

    @DeleteMapping(value = "/product/coffee/{name}")
    public String deleteCoffeeInfo(@PathVariable String name){
        return ps.deleteCoffeeInfo(name);
    }



}

package com.example.productapi.controller;


import com.example.productapi.entity.Coffee;
import com.example.productapi.dto.CoffeeEditRequest;
import com.example.productapi.dto.CoffeeInsertRequest;
import com.example.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService ps;

    @GetMapping(value = "/product/coffee/{name}")
    public Coffee getCoffeeInfo(@PathVariable String name){   //기능
        return ps.getCoffeeInfo(name);
    }

    @PostMapping(value = "/product/coffee")
    public ResponseEntity insertCoffeeInfo(@RequestBody CoffeeInsertRequest coffeeInsertRequest){
        return ps.insertCoffeeInfo(coffeeInsertRequest);
    }

    @PutMapping(value = "/product/coffee")
    public ResponseEntity putCoffeeInfo(@RequestBody CoffeeEditRequest coffeeEditRequest){
        return ps.putCoffeeInfo(coffeeEditRequest);
    }

    @DeleteMapping(value = "/product/coffee/{name}")
    public ResponseEntity deleteCoffeeInfo(@PathVariable String name){
        return ps.deleteCoffeeInfo(name);
    }



}

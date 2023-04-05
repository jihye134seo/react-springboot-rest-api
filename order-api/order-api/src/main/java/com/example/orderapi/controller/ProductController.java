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

    @RequestMapping(value = "/product/coffee/{cid}", method = RequestMethod.GET)
    public Coffee getCoffeeInfo(@RequestParam UUID cid){   //기능
        return ps.getCoffeeInfo(cid);
    }

    @RequestMapping(value = "/product/coffee", method = RequestMethod.POST)
    public String insertCoffeeInfo(@RequestBody CoffeeInsertRequest coffeeInsertRequest){
        return ps.insertCoffeeInfo(coffeeInsertRequest);
    }

    @RequestMapping(value = "/product/coffee", method = RequestMethod.PUT)
    public String putCoffeeInfo(@RequestBody CoffeeEditRequest coffeeEditRequest){
        return ps.putCoffeeInfo(coffeeEditRequest);
    }

    @RequestMapping(value = "/product/coffee/{cid}", method = RequestMethod.DELETE)
    public String deleteCoffeeInfo(@RequestParam UUID cid){
        return ps.deleteCoffeeInfo(cid);
    }



}

package com.example.orderapi.service;


import com.example.orderapi.entity.client.Coffee;
import com.example.orderapi.entity.client.CoffeeEditRequest;
import com.example.orderapi.entity.client.CoffeeInsertRequest;
import com.example.orderapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository pr;

    public Coffee getCoffeeInfo(UUID cid){
        return pr.getCoffeeInfo(cid);
    }

    public String insertCoffeeInfo(CoffeeInsertRequest coffeeInsertRequest) {

        Coffee coffee = new Coffee(
                UUID.randomUUID(),
                coffeeInsertRequest.getName(),
                coffeeInsertRequest.getPrice(),
                coffeeInsertRequest.getOrigin(),
                coffeeInsertRequest.getProducer()
        );

        pr.insertCoffeeInfo(
                coffee.getCid(),
                coffee.getName(),
                coffee.getPrice(),
                coffee.getOrigin(),
                coffee.getProducer()
        );
    }

    public String putCoffeeInfo(CoffeeEditRequest coffeeEditRequest) {

        UUID cid = coffeeEditRequest.getCid();
        Optional<String> name = coffeeEditRequest.getName();
        Optional<Long> price = coffeeEditRequest.getPrice();
        Optional<String> origin = coffeeEditRequest.getOrigin();
        Optional<String> producer = coffeeEditRequest.getProducer();

        ps.putCoffeeInfo(
                cid,
                name == null ? null :

        )


    }



    public String deleteCoffeeInfo(UUID cid) {
        pr.deleteCoffeeInfo(cid);
    }
}

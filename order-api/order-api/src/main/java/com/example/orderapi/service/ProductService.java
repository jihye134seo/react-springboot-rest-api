package com.example.orderapi.service;


import com.example.orderapi.entity.client.Coffee;
import com.example.orderapi.entity.client.CoffeeEditRequest;
import com.example.orderapi.entity.client.CoffeeInsertRequest;
import com.example.orderapi.repository.CoffeeProductRepository;
import com.example.orderapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    CoffeeProductRepository pr;

    public Coffee getCoffeeInfo(UUID cid){
        return pr.getCoffeeInfo(cid);
    }

    public String insertCoffeeInfo(CoffeeInsertRequest coffeeInsertRequest) {

        try{

            return "OK";
        }
        catch(Exception e){
            return "fail";
        }

    }

    public String putCoffeeInfo(CoffeeEditRequest coffeeEditRequest) {

        try{
            UUID cid = coffeeEditRequest.getCid();
            Optional<String> name = coffeeEditRequest.getName();
            Optional<Long> price = coffeeEditRequest.getPrice();
            Optional<String> origin = coffeeEditRequest.getOrigin();
            Optional<String> producer = coffeeEditRequest.getProducer();

            Coffee lastInfo = pr.getCoffeeInfo(cid);

            pr.putCoffeeInfo(
                    cid,
                    name == null ? lastInfo.getName() : name,
                    price == null ? lastInfo.getPrice() : price,
                    origin == null ? lastInfo.getOrigin() : origin,
                    producer == null ? lastInfo.getProducer() : producer
            );

            return "OK";
        }
        catch(Exception e){
            return "fail";
        }

    }



    public String deleteCoffeeInfo(UUID cid) {

        try{
            pr.deleteCoffeeInfo(cid);

            return "OK";
        }
        catch(Exception e){
            return "fail";
        }
    }

}

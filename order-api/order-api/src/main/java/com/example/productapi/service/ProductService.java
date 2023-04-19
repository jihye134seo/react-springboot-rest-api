package com.example.productapi.service;


import com.example.productapi.entity.Coffee;
import com.example.productapi.dto.CoffeeEditRequest;
import com.example.productapi.dto.CoffeeInsertRequest;
import com.example.productapi.repository.CoffeeProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CoffeeProductRepository pr;

    public Coffee getCoffeeInfo(String name){
        return pr.getCoffeeInfo(name);
    }

    @Transactional
    public String insertCoffeeInfo(CoffeeInsertRequest coffeeInsertRequest) {

        try{
            pr.insertCoffeeInfo(
                UUID.randomUUID(),
                coffeeInsertRequest.getName(),
                coffeeInsertRequest.getPrice(),
                coffeeInsertRequest.getOrigin(),
                coffeeInsertRequest.getProducer()
            );

            return "OK";
        }
        catch(Exception e){
            return "fail";
        }
    }

    @Transactional
    public String putCoffeeInfo(CoffeeEditRequest coffeeEditRequest) {

        try{
            String name = coffeeEditRequest.getName();
            Long price = coffeeEditRequest.getPrice();
            String origin = coffeeEditRequest.getOrigin();
            String producer = coffeeEditRequest.getProducer();

            Coffee prevInfo = pr.getCoffeeInfo(name);

            if(prevInfo == null){
                return "fail";
            }

            Long newPrice = price == null ? prevInfo.getPrice() : price;
            String newOrigin = origin == null ? prevInfo.getOrigin() : origin;
            String newProducer = producer == null ? prevInfo.getProducer() : producer;

            pr.putCoffeeInfo(
                    name, newPrice, newOrigin, newProducer
            );

            return "OK";
        }
        catch(Exception e){
            return "fail";
        }

    }

    @Transactional
    public String deleteCoffeeInfo(String name) {

        try{
            pr.deleteCoffeeInfo(name);
            return "OK";
        }
        catch(Exception e){
            return "fail";
        }
    }

}

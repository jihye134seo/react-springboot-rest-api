package com.example.productapi.service;


import com.example.productapi.entity.Coffee;
import com.example.productapi.dto.CoffeeEditRequest;
import com.example.productapi.dto.CoffeeInsertRequest;
import com.example.productapi.repository.CoffeeProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity insertCoffeeInfo(CoffeeInsertRequest coffeeInsertRequest) {

        try{
            pr.insertCoffeeInfo(
                UUID.randomUUID(),
                coffeeInsertRequest.getName(),
                coffeeInsertRequest.getPrice(),
                coffeeInsertRequest.getOrigin(),
                coffeeInsertRequest.getProducer()
            );

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity putCoffeeInfo(CoffeeEditRequest coffeeEditRequest) {

        try{
            String name = coffeeEditRequest.getName();
            Long price = coffeeEditRequest.getPrice();
            String origin = coffeeEditRequest.getOrigin();
            String producer = coffeeEditRequest.getProducer();

            Coffee prevInfo = pr.getCoffeeInfo(name);

            if(prevInfo == null){
                return new ResponseEntity(HttpStatus.CONFLICT);
            }

            Long newPrice = price == null ? prevInfo.getPrice() : price;
            String newOrigin = origin == null ? prevInfo.getOrigin() : origin;
            String newProducer = producer == null ? prevInfo.getProducer() : producer;

            pr.putCoffeeInfo(
                    name, newPrice, newOrigin, newProducer
            );

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional
    public ResponseEntity deleteCoffeeInfo(String name) {

        try{
            pr.deleteCoffeeInfo(name);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.example.orderapi.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

//    private final CoffeeProductRepository pr;
//
//    public Coffee getCoffeeInfo(Long oid){
//        return pr.getCoffeeInfo(oid);
//    }
//
//    @Transactional
//    public String insertCoffeeInfo(CoffeeInsertRequest coffeeInsertRequest) {
//
//        try{
//            pr.insertCoffeeInfo(
//                UUID.randomUUID(),
//                coffeeInsertRequest.getName(),
//                coffeeInsertRequest.getPrice(),
//                coffeeInsertRequest.getOrigin(),
//                coffeeInsertRequest.getProducer()
//            );
//
//            return "OK";
//        }
//        catch(Exception e){
//            return "fail";
//        }
//    }
//
//    @Transactional
//    public String putCoffeeInfo(CoffeeEditRequest coffeeEditRequest) {
//
//        try{
//            String name = coffeeEditRequest.getName();
//            Long price = coffeeEditRequest.getPrice();
//            String origin = coffeeEditRequest.getOrigin();
//            String producer = coffeeEditRequest.getProducer();
//
//            Coffee prevInfo = pr.getCoffeeInfo(name);
//
//            if(prevInfo == null){
//                return "fail";
//            }
//
//            Long newPrice = price == null ? prevInfo.getPrice() : price;
//            String newOrigin = origin == null ? prevInfo.getOrigin() : origin;
//            String newProducer = producer == null ? prevInfo.getProducer() : producer;
//
//            pr.putCoffeeInfo(
//                    name, newPrice, newOrigin, newProducer
//            );
//
//            return "OK";
//        }
//        catch(Exception e){
//            return "fail";
//        }
//
//    }
//
//    @Transactional
//    public String deleteCoffeeInfo(String name) {
//
//        try{
//            pr.deleteCoffeeInfo(name);
//            return "OK";
//        }
//        catch(Exception e){
//            return "fail";
//        }
//    }

}

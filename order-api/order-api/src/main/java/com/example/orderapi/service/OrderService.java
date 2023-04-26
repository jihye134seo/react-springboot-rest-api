package com.example.orderapi.service;


import com.example.orderapi.dto.OrderGetResponse;
import com.example.orderapi.dto.OrderPostRequest;
import com.example.orderapi.entity.CoffeeAndOrder;
import com.example.orderapi.entity.Order;
import com.example.orderapi.repository.CoffeeAndOrderRepository;
import com.example.orderapi.repository.OrderRepository;
import com.example.productapi.entity.Coffee;
import com.example.productapi.repository.CoffeeProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {


    private final OrderRepository orderRepository;
    private final CoffeeAndOrderRepository coffeeAndOrderRepository;
    private final CoffeeProductRepository coffeeProductRepository;

    public OrderGetResponse getOrderInfo(Long oid) {

        try{
            Order order = orderRepository.findByOrderId(oid);
            CoffeeAndOrder coffeeAndOrder = coffeeAndOrderRepository.findCoffeeAndOrder(oid);
            Coffee coffee = coffeeProductRepository.findByCoffeeId(coffeeAndOrder.getCid().getCid().toString());

            return OrderGetResponse.builder()
                    .order(order)
                    .coffee(coffee)
                    .count(coffeeAndOrder.getCount())
                    .build();
        }
        catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Transactional
    public ResponseEntity insertOrderInfo(OrderPostRequest orderPostRequest) {

        try{

            log.warn(orderPostRequest.getCid().toString());

            Coffee coffee = coffeeProductRepository.findByCoffeeId(orderPostRequest.getCid().toString());

            log.warn(coffee.getName());

            Order order = Order.builder()
                        .totalPrice(coffee.getPrice() * orderPostRequest.getCount())
                        .totalNumber(orderPostRequest.getCount())
                        .createdTime(LocalDateTime.now())
                        .build();

            orderRepository.save(order);

            log.info(String.valueOf(order.getTotalNumber()));

            CoffeeAndOrder coffeeAndOrder = CoffeeAndOrder.builder()
                                                .oid(order)
                                                .cid(coffee)
                                                .count(orderPostRequest.getCount())
                                                .build();

            coffeeAndOrderRepository.save(coffeeAndOrder);


            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            log.info(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity deleteOrderInfo(Long oid) {

        try{
            coffeeAndOrderRepository.deleteByOid(oid);
            orderRepository.deleteById(oid);

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            log.info(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

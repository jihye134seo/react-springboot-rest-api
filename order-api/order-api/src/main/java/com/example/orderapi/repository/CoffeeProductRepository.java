package com.example.orderapi.repository;

import com.example.orderapi.entity.client.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface CoffeeProductRepository extends JpaRepository<Coffee, UUID> {



    @Query(value = "SELECT * FROM order.coffee c WHERE c.cid = :cid", nativeQuery = true)
    Coffee getCoffeeInfo(UUID cid);

    @Query(value = "SELECT * FROM order.coffee c WHERE c.cid = :cid", nativeQuery = true)
    void insertCoffeeInfo(UUID cid, String name, Long price, String origin, String producer);

//    @Query(value = "SELECT * FROM order.coffee c WHERE c.cid = :cid", nativeQuery = true)
    public void putCoffeeInfo(UUID cid, Object o, Object o1, Object o2, Object o3);

//    @Query(value = "SELECT * FROM order.coffee c WHERE c.cid = :cid", nativeQuery = true)
    public void deleteCoffeeInfo(UUID cid);
}

package com.example.orderapi.repository;

import com.example.orderapi.entity.client.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public interface CoffeeProductRepository extends JpaRepository<Coffee, UUID> {



    @Query(value = "SELECT * FROM orders.coffee c WHERE c.name = :name", nativeQuery = true)
    Coffee getCoffeeInfo(String name);

    @Modifying
    @Query(value = "INSERT INTO `orders`.`coffee` (cid, created_time, `name`, origin, price, producer) VALUES (:cid, now(), :name, :origin, :price, :producer)", nativeQuery = true)
    void insertCoffeeInfo(UUID cid, String name, Long price, String origin, String producer);

    @Modifying
    @Query(value = "UPDATE `orders`.`coffee` SET `price` = :price, `origin` = :origin, `producer` = :producer  WHERE (`name` = :name)", nativeQuery = true)
    void putCoffeeInfo(String name, Long price, String origin, String producer);

    @Modifying
    @Query(value = "DELETE FROM `orders`.`coffee` WHERE (`name` = :name)", nativeQuery = true)
    void deleteCoffeeInfo(String name);


}

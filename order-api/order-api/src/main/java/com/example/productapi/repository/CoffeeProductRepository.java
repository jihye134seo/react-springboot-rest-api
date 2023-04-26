package com.example.productapi.repository;

import com.example.productapi.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CoffeeProductRepository extends JpaRepository<Coffee, UUID> {



    @Query(value = "SELECT * FROM `coffee-orders`.`coffee` c WHERE c.`name` = :name", nativeQuery = true)
    Coffee getCoffeeInfo(String name);

    @Modifying
    @Query(value = "INSERT INTO `coffee-orders`.`coffee` (cid, created_time, `name`, origin, price, producer) VALUES (:cid, now(), :name, :origin, :price, :producer)", nativeQuery = true)
    void insertCoffeeInfo(UUID cid, String name, Long price, String origin, String producer);

    @Modifying
    @Query(value = "UPDATE `coffee-orders`.`coffee` SET `price` = :price, `origin` = :origin, `producer` = :producer  WHERE (`name` = :name)", nativeQuery = true)
    void putCoffeeInfo(String name, Long price, String origin, String producer);

    @Modifying
    @Query(value = "DELETE FROM `coffee-orders`.`coffee` WHERE (`name` = :name)", nativeQuery = true)
    void deleteCoffeeInfo(String name);

    @Query(value = "SELECT * FROM `coffee-orders`.`coffee` c WHERE c.cid = uuid_to_bin(:cid)", nativeQuery = true)
    Coffee findByCoffeeId(String cid);
}

package com.example.orderapi.repository;

import com.example.orderapi.entity.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeAndOrderRepository extends JpaRepository<CoffeeOrder, Long> {

    @Query(value = "SELECT * FROM `coffee-orders`.`coffee_order` c WHERE c.oid = :oid", nativeQuery = true)
    CoffeeOrder findCoffeeAndOrder(Long oid);
    @Modifying
    @Query(value = "DELETE FROM `coffee-orders`.`coffee_order` WHERE (`oid` = :oid)", nativeQuery = true)
    void deleteByOid(Long oid);
}

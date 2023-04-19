package com.example.orderapi.repository;

import com.example.orderapi.entity.CoffeeAndOrder;
import com.example.orderapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeAndOrderRepository extends JpaRepository<CoffeeAndOrder, Long> {

    @Query(value = "SELECT * FROM `coffee-orders`.`coffee_and_order_tb` c WHERE c.oid = :oid", nativeQuery = true)
    CoffeeAndOrder findCoffeeAndOrder(Long oid);
    @Modifying
    @Query(value = "DELETE FROM `coffee-orders`.`coffee_and_order_tb` WHERE (`oid` = :oid)", nativeQuery = true)
    void deleteByOid(Long oid);
}

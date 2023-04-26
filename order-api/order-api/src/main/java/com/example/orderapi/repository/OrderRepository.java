package com.example.orderapi.repository;

import com.example.orderapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository  extends JpaRepository<Order, Long> {

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long getOrderId();

    @Query(value = "SELECT * FROM `coffee-orders`.`order_tb` o WHERE o.`oid` = :oid", nativeQuery = true)
    Order findByOrderId(Long oid);

}

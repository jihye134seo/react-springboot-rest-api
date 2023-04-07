package com.example.orderapi.entity.client;

import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
public class CoffeeEditRequest {

//    UUID cid;
    String name;
    Long price;
    String origin;
    String producer;

//    public UUID getCid() {
//        return cid;
//    }

//    public void setCid(UUID cid) {
//        this.cid = cid;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

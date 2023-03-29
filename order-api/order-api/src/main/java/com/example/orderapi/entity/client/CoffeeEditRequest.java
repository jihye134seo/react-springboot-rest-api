package com.example.orderapi.entity.client;

import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
public class CoffeeEditRequest {

    UUID cid;
    Optional<String> name;
    Optional<Long> price;
    Optional<String> origin;
    Optional<String> producer;

    public UUID getCid() {
        return cid;
    }

    public void setCid(UUID cid) {
        this.cid = cid;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<Long> getPrice() {
        return price;
    }

    public void setPrice(Optional<Long> price) {
        this.price = price;
    }

    public Optional<String> getOrigin() {
        return origin;
    }

    public void setOrigin(Optional<String> origin) {
        this.origin = origin;
    }

    public Optional<String> getProducer() {
        return producer;
    }

    public void setProducer(Optional<String> producer) {
        this.producer = producer;
    }
}

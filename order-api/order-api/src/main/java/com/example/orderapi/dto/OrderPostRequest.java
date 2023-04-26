package com.example.orderapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class OrderPostRequest {

    UUID cid;
    Long count;

}

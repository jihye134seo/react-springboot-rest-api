package com.example.orderapi.entity.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class OrderPostRequest {

    HashMap<String, Integer> coffee_list;       //커피이름, 커피 개수

}

package com.cebisli.orderapi.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Product implements Serializable{
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private int price;
}

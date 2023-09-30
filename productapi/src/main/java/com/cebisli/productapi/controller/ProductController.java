package com.cebisli.productapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebisli.productapi.dtos.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
     @GetMapping("/list")
    public List<Product> getAllMovies() {

        List<Product> products = new ArrayList<Product>();

        products.add(new Product("elma", 4));
        products.add(new Product("armut", 7));

        return products;
    }
}

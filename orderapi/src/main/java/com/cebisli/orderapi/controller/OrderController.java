package com.cebisli.orderapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cebisli.orderapi.dto.Order;
import com.cebisli.orderapi.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public List<Order> get() {
        List<Order> orders = new ArrayList<>();

        List<ServiceInstance> instances = discoveryClient.getInstances("productapi");
        if (instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String url = serviceInstance.getUri().toString();
            url = url + "/product/list";
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Object[]> objectResponseEntity = restTemplate.getForEntity(url, Object[].class);
            Object[] objects = objectResponseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            List<Product> result = Arrays.stream(objects)
                    .map(object -> mapper.convertValue(object, Product.class))
                    .collect(Collectors.toList());

            for (Product product : result) {
                orders.add(new Order(product, 5));
            }
        }
        return orders;
    }
}

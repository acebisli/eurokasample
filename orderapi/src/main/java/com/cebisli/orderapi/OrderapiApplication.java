package com.cebisli.orderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderapiApplication.class, args);
	}

}

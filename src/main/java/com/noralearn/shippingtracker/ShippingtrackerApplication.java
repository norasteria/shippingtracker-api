package com.noralearn.shippingtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShippingtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingtrackerApplication.class, args);
	}

}

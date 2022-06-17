package com.rapsShopping.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RapsShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapsShoppingApplication.class, args);
	}

}

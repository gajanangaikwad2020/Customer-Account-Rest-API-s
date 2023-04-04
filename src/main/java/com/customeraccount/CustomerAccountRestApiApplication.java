package com.customeraccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerAccountRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountRestApiApplication.class, args);
		System.out.println("Account Service Started");
	}

}

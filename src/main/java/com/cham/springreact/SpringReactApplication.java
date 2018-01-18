package com.cham.springreact;

import com.cham.springreact.client.ReactClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringReactApplication.class, args);

		ReactClient reactClient = new ReactClient();
		reactClient.createOrder();
		reactClient.printAllOrders();
		//reactClient.getOrder("1");
	}
}

package com.cham.springreact;

import com.cham.springreact.client.ReactClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Chaminda Wijayasundara on 13 Jan 2018
 */

@SpringBootApplication
public class SpringReactApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringReactApplication.class, args);

		ReactClient reactClient = new ReactClient();
		reactClient.createOrder();
		reactClient.printAllOrders();
		reactClient.getOrder("1");
	}
}

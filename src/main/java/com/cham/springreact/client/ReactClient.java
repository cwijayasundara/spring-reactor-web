package com.cham.springreact.client;

import com.cham.springreact.dto.Order;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactClient {

    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = client.get()
            .uri("/order")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    // work in progress
    public String getOrders() {
        System.out.println("inside the ReactClient.getOrders");
        Flux <Order> order = result.flatMapMany(res-> res.bodyToFlux(Order.class));
        return order.toString();
    }
}

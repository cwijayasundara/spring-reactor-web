package com.cham.springreact.client;

import com.cham.springreact.dto.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;


/**
 * Created by Chaminda Wijayasundara on 13 Jan 2018
 */

public class ReactClient{

    private ExchangeFunction exchange = ExchangeFunctions.create(new ReactorClientHttpConnector());

    private final String setUpStr= "http://%s:%d/order";

    private final String hostStr="localhost";

    private final int port= 8080;

    public void printAllOrders() {
        URI uri = URI.create(String.format(setUpStr, hostStr, port));
        ClientRequest request = ClientRequest.method(HttpMethod.GET, uri).build();

        Flux<Order> orderFlux = exchange.exchange(request)
                .flatMapMany(response -> response.bodyToFlux(Order.class));

        Mono<List<Order>> orderList = orderFlux.collectList();
        System.out.println(orderList.block());
    }

    public void createOrder() {
        URI uri = URI.create(String.format(setUpStr, hostStr, port));
        Order jose_doe = new Order("3", "Jose Doe", "23 Mountain road Calif");

        ClientRequest request = ClientRequest.method(HttpMethod.POST, uri)
                .body(BodyInserters.fromObject(jose_doe)).build();

        Mono<ClientResponse> response = exchange.exchange(request);
        System.out.println(response.block().statusCode());
    }

    public void getOrder(String id) {
        URI uri = URI.create(String.format("http://%s:%d/order/1", hostStr, port));
        ClientRequest request = ClientRequest.method(HttpMethod.GET, uri).build();

        Flux<Order> orderFlux = exchange.exchange(request)
                .flatMapMany(response -> response.bodyToFlux(Order.class));

        Mono<List<Order>> orderList = orderFlux.collectList();
        System.out.println(orderList.block());
    }
}

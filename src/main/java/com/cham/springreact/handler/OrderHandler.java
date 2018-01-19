package com.cham.springreact.handler;

import com.cham.springreact.dto.Order;
import com.cham.springreact.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * Created by Chaminda Wijayasundara on 13 Jan 2018
 */

@Component
public class OrderHandler {

    @Autowired
    private final OrderRepo repository;

    // constructor
    public OrderHandler(OrderRepo orderRepo) {
        this.repository = orderRepo;
    }

    public Mono<ServerResponse> getOrder(ServerRequest request) {

        String orderId = request.pathVariable("orderId");

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Order> orderMono = this.repository.getOrder(orderId);
        return orderMono
                .flatMap(order -> ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromObject(order)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> createOrder(ServerRequest request) {
        System.out.println("Inside OrderHandler.createOrder");
        Mono<Order> order = request.bodyToMono(Order.class);
        return ServerResponse.ok().build(this.repository.saveOrder(order));
    }

    public Mono<ServerResponse> listOrders(ServerRequest request) {
        System.out.println("Inside OrderHandler.listOrders");
        Flux<Order> orders = this.repository.getAllOrders();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(orders, Order.class);
    }
}

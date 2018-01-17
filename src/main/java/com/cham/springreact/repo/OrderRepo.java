package com.cham.springreact.repo;

import com.cham.springreact.dto.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepo {
    Mono<Order> getOrder(String orderId);
    Flux<Order> getAllOrders();
    Mono<Void> saveOrder(Mono<Order> order);
}

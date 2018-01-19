package com.cham.springreact.repo;

import com.cham.springreact.dto.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Chaminda Wijayasundara on 13 Jan 2018
 */

public interface OrderRepo {
    Mono<Order> getOrder(String orderId); // Mono emit one event
    Flux<Order> getAllOrders();// Flux emit multiple events
    Mono<Void> saveOrder(Mono<Order> order);
}

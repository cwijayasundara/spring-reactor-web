package com.cham.springreact.repo;

import com.cham.springreact.dto.Order;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderRepoDummyImpl implements OrderRepo {

    private final Map<Integer, Order> orders = new HashMap<>();

    public OrderRepoDummyImpl() {
        this.orders.put(1, new Order("1", "Jane Doe", "14 Moon road US"));
        this.orders.put(2, new Order("2", "John Doe", "12 Star street UK"));
    }

    @Override
    public Mono<Order> getOrder(String id) {
        return Mono.justOrEmpty(this.orders.get(id));
    }

    @Override
    public Flux<Order> getAllOrders() {
        return Flux.fromIterable(this.orders.values());
    }

    @Override
    public Mono<Void> saveOrder(Mono<Order> orderMono) {
        return orderMono.doOnNext(order -> {
            int id = orders.size() + 1;
            orders.put(id, order);
            System.out.format("Saved %s with id %d%n", order, id);
        }).thenEmpty(Mono.empty());
    }


}

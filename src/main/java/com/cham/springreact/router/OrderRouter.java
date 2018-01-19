package com.cham.springreact.router;

import com.cham.springreact.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by Chaminda Wijayasundara on 13 Jan 2018
 */

@Configuration
public class OrderRouter {

    @Bean
    public RouterFunction<ServerResponse> route(OrderHandler orderHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/order").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), orderHandler::listOrders)
                .andRoute(RequestPredicates.POST("/order").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), orderHandler::createOrder)
                .andRoute(RequestPredicates.GET("/order/{orderId}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), orderHandler::getOrder);
    }
}

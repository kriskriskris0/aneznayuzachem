package org.example;

import org.model.BusStop;
import org.model.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

//    @Bean
//    public Order order() {
//        Order order = new Order();
//        order.setId(1);
//        order.setName("Test order");
//
//        return order;
//    }

    @Bean
    public Route route() {
        Route route = new Route();
        route.setId(1L);
        route.setName(7);

        return route;
    }

}

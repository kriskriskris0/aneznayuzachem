package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    public Order order() {
        Order order = new Order();
        order.setId(1);
        order.setName("Test order");

        return order;
    }

}

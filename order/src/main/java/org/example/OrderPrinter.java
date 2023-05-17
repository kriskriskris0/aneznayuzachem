package org.example;
import org.springframework.stereotype.Component;

@Component
public class OrderPrinter {

    public void printOrder(Order order) {
        System.out.println("Order ID: " + order.getId());
        System.out.println("Name: " + order.getName());
    }

}
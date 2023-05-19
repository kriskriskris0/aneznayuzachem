package org.example;
import org.model.Route;
import org.springframework.stereotype.Component;

@Component
public class OrderPrinter {

//    public void printOrder(Order order) {
//        System.out.println("Order ID: " + order.getId());
//        System.out.println("Name: " + order.getName());
//    }

    public void printRoute(Route route) {
        System.out.println("route ID: " + route.getId());
        System.out.println("Name: " + route.getName());
    }
}
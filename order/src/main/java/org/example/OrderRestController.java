package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgres")
public class OrderRestController {

    private final OrderRepository orderRepository;
    public PostgresTest postgresTest;

    public OrderRestController(OrderRepository orderRepository, PostgresTest postgresTest) {
        this.orderRepository = orderRepository;
        this.postgresTest=postgresTest;
    }

    @GetMapping
    public Order createOrder() {
         postgresTest.createOrder(1,20);
        return null;
    }

//    @GetMapping
    public List<BusStopEntity> getAllOrders() {
        return orderRepository.get();
    }

    @GetMapping("/{clientId}")
    public Order findAllByClientId(@PathVariable long id) {
        return orderRepository.getClientId(id);
    }

    @PutMapping("/{clientId}")
    public void findAllByClientId(@PathVariable long id, @RequestBody Order order) {
        order.setId(id);
        orderRepository.update(order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id) {
        return orderRepository.getById(id);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable long id, @RequestBody Order order) {
        order.setId(id);
        orderRepository.update(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) {
        Order order = orderRepository.getById(id);
        orderRepository.delete(order.getId());
    }

}
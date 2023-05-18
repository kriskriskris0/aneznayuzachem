package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgres")
public class OrderRestController {

    private final ScheduleRepository scheduleRepository;
    public PostgresTest postgresTest;

    public OrderRestController(ScheduleRepository scheduleRepository, PostgresTest postgresTest) {
        this.scheduleRepository = scheduleRepository;
        this.postgresTest=postgresTest;
    }

    @GetMapping
    public Order createOrder() {
         postgresTest.createOrder(1,20);
        return null;
    }

//    @GetMapping
    public List<BusStopEntity> getAllOrders() {
        return scheduleRepository.get();
    }

    @GetMapping("/{clientId}")
    public Order findAllByClientId(@PathVariable long Id) {
        return scheduleRepository.getBusId(Id);
    }

    @PutMapping("/{clientId}")
    public void findAllByClientId(@PathVariable long id, @RequestBody Order order) {
        order.setId(id);
        scheduleRepository.update(order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long Id) {
        return scheduleRepository.getBusId(Id);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable long id, @RequestBody Order order) {
        order.setId(id);
        scheduleRepository.update(order);
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable long id) {
        Order order = scheduleRepository.getBusId(id);
        scheduleRepository.delete(order.getId());
    }

}
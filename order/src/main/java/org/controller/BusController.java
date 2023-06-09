package org.controller;

import org.model.Bus;
import org.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusService service;

    public BusController(BusService service) {
        this.service = service;
    }
    @PostMapping("create")
    public Bus create(@RequestBody Bus bus) {
        return service.create(bus);
    }

    @PostMapping("update")
    public Bus update(@RequestBody Bus bus) {
        return service.update(bus);
    }

    @PostMapping("delete")
    public Bus delete(@RequestBody Bus bus) { return service.delete(bus); }

    @GetMapping("getByName/{name}")
    public Optional<Bus> getByName(@PathVariable String name) {
        return service.getBusByName(name);
    }

    @GetMapping("getAll")
    public List<Bus> getAll() {
        return service.getAllBus();
    }
}

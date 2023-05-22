package org.controller;

import org.model.Route;
import org.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }
    @PostMapping("create")
    public Route create(@RequestBody Route route) {
        return service.create(route);
    }
    @PostMapping("update")
    public Route update(@RequestBody Route route) {
        return service.update(route);
    }
    @PostMapping("delete")
    public Route delete(@RequestBody Route route) {
        return service.delete(route);
    }
    @GetMapping("get/{name}")
    public Optional<Route> get(@PathVariable String name) { return service.getName(name); }

}

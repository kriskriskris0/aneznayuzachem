package org.controller;

import org.model.Route;
import org.service.RouteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }
    @PostMapping
    public Route create(@RequestBody Route route) {
        return service.create(route);
    }

    //update
    //delete
    //get
}

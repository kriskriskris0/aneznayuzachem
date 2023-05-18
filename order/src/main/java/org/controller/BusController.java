package org.controller;

import org.model.Bus;
import org.service.BusService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusService service;

    public BusController(BusService service) {
        this.service = service;
    }
    @PostMapping
    public Bus create(@RequestBody Bus bus) {
        return service.create(bus);
    }

    //update
    //delete
    //get
}

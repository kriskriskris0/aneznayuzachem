package org.controller;

import org.model.BusStop;
import org.service.BusStopService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/busStop")
public class BusStopController {

    private final BusStopService service;

    public BusStopController(BusStopService service) {
        this.service = service;
    }

    @PostMapping
    public BusStop create(@RequestBody BusStop busStop) {
        return service.create(busStop);
    }

    @GetMapping("getByAddress/{address}")
    public Optional<BusStop> getByAddress(@PathVariable String address) {
        return service.getBusStopByAddress(address);
    }

    @GetMapping("getAll")
    public List<BusStop> getAll() {
        return service.getAllBusStop();
    }

    //update
    //delete
}


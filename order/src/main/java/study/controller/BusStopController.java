package study.controller;

import study.model.BusStop;
import study.service.BusStopService;
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

    @PostMapping("create")
    public BusStop create(@RequestBody BusStop busStop) {

        return service.create(busStop);
    }

    @PutMapping("update")
    public BusStop update(@RequestBody BusStop busStop) {

        return service.update(busStop);
    }

    @DeleteMapping("delete")
    public BusStop delete(@RequestBody BusStop busStop) {
        return service.delete(busStop);
    }

    @GetMapping("getByAddress/{address}")
    public Optional<BusStop> getByAddress(@PathVariable String address) {
        return service.getBusStopByAddress(address);
    }

    @GetMapping("getAll")
    public List<BusStop> getAll() {
        return service.getAllBusStop();
    }
}


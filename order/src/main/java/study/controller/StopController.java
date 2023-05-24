package study.controller;

import study.model.Stop;
import study.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/stop")
public class StopController {

    private final StopService service;

    public StopController(StopService service) {

        this.service = service;
    }

    @PostMapping("create")
    public Stop create(@RequestBody Stop stop) {

        return service.create(stop);
    }

    @PutMapping("update")
    public Stop update(@RequestBody Stop stop) {

        return service.update(stop);
    }

    @DeleteMapping("delete")
    public Stop delete(@RequestBody Stop stop) {
        return service.delete(stop);
    }

    @GetMapping("get/{address}")
    public Optional<Stop> get(@PathVariable String address) {
        return service.getStopByAddress(address);
    }

    @GetMapping("getAll")
    public List<Stop> getAll() {
        return service.getAllStop();
    }
}


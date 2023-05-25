package study.controller;

import study.model.Bus;
import study.service.BusService;
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

    @PutMapping("update")
    public Bus update(@RequestBody Bus bus) {
        return service.update(bus);
    }

    @DeleteMapping("delete")
    public Bus delete(@RequestBody Bus bus) { return service.delete(bus); }

    @GetMapping("get/{name}")
    public Optional<Bus> get(@PathVariable String name) {
        return service.getBusByName(name);
    }

    @GetMapping("getAll")
    public List<Bus> getAll() {
        return service.getAllBus();
    }
}

package study.controller;

import org.springframework.web.bind.annotation.*;
import study.model.Bus;
import study.model.Schedule;
import study.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) { this.service = service; }
    @PostMapping("create")
    public Schedule create(@RequestBody Schedule schedule) { return service.create(schedule); }
    @GetMapping("getBus/{name}")
    public Bus getBusByName(@RequestBody String name) {return service.findBusByName(name);}
    @PutMapping("update")
    public Schedule update(@RequestBody Schedule schedule) { return service.update(schedule); }
    @DeleteMapping("delete")
    public Schedule delete(@RequestBody Schedule schedule) { return service.delete(schedule); }
    @GetMapping("getAll")
    public List<Schedule> getAll() { return service.getAllSchedule(); }

}
package study.controller;

import study.model.Schedule;
import study.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) { this.service = service; }
    @PostMapping("create")
    public Schedule create(@RequestBody Schedule schedule) { return service.create(schedule); }
    @PutMapping("update")
    public Schedule update(@RequestBody Schedule schedule) { return service.update(schedule); }
    @DeleteMapping("delete")
    public Schedule delete(@RequestBody Schedule schedule) { return service.delete(schedule); }

}

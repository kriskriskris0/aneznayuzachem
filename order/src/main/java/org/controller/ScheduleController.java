package org.controller;

import org.model.Schedule;
import org.service.ScheduleService;
import org.service.RouteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Time;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) { this.service = service; }
    @PostMapping
    public Schedule create(@RequestBody Schedule schedule) { return service.create(schedule); }
    @PostMapping
    public Schedule get(@RequestBody Time time) { return service.get(time); }
    @PostMapping
    public Schedule delete(@RequestBody Schedule schedule) { return service.delete(schedule); }
    @PostMapping
    public Schedule update(@RequestBody Schedule schedule) { return service.update(schedule); }
}
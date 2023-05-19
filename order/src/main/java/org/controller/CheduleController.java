package org.controller;

import org.model.Chedule;
import org.service.CheduleService;
import org.service.RouteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Time;

@RestController
@RequestMapping("/chedule")
public class CheduleController {

    private final CheduleService service;

    public CheduleController(CheduleService service) { this.service = service; }
    @PostMapping
    public Chedule create(@RequestBody Chedule chedule) { return service.create(chedule); }
    @PostMapping
    public Chedule get(@RequestBody Time time) { return service.get(time); }
    @PostMapping
    public Chedule delete(@RequestBody Chedule chedule) { return service.delete(chedule); }
    @PostMapping
    public Chedule update(@RequestBody Chedule chedule) { return service.update(chedule); }
}

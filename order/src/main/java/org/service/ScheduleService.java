package org.service;

import org.model.Schedule;
import org.repository.ScheduleRepository;

public class ScheduleService {

    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule create(Schedule schedule) {

        //TODO переделать проверку существующего маршрута на ВРЕМЯ маршрута
        // Подсказка: Написать в нужном ДАО метод findByName(Time time) УЖЕ СДЕЛАЛ!
        Schedule existSchedule = repository.get(schedule.getTime());

        if (existSchedule == null) {
            return repository.create(schedule);
        }

        throw new RuntimeException("Этот Chedule уже есть");
    }


    //update
    //delete
    //get
}

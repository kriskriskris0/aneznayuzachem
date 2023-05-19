package org.service;

import org.model.Schedule;
import org.repository.ScheduleRepository;

import java.sql.Time;

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

        throw new RuntimeException("Этот Schedule уже есть");
    }


    public Schedule get(Time time){
        Schedule existSchedule = repository.get(time);
        return existSchedule;
    }

    public Schedule delete(Schedule schedule){
        if(schedule == null)
            throw new RuntimeException("Такого Schedule для удаления нет");
        return repository.delete(schedule);
    }
    //update
    public Schedule update(Schedule schedule){
        if(schedule == null)
            throw new RuntimeException("Такого Schedule для обновления нет");
        return repository.update(schedule);
    }
    //update
    //delete
    //get
}

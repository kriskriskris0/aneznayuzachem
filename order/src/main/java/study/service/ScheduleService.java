package study.service;

import study.model.Bus;
import study.model.Schedule;
import org.modelmapper.ModelMapper;
import study.repository.ScheduleRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class ScheduleService {

    private final ScheduleRepository repository;

    private final ModelMapper modelMapper;

    public ScheduleService(ScheduleRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Bus findBusByName(String name){
        Bus existBus = repository.getBus(name);
        if(existBus != null){
            return existBus;
        }
        throw new RuntimeException("Такого автобуса в расписании нет");
    }

    public Schedule create(Schedule schedule) {

        //TODO переделать проверку существующего маршрута на ВРЕМЯ маршрута
        // Подсказка: Написать в нужном ДАО метод findByTime(Time time) УЖЕ СДЕЛАЛ!
        Schedule existSchedule = repository.get(schedule.getTime());

        if (existSchedule == null) {
            return repository.create(schedule);
        }

        throw new RuntimeException("Такое расписание уже есть");
    }


    public Schedule update(Schedule schedule) {
        Schedule existSchedule = repository.get(Time.valueOf(String.valueOf(schedule.getId())));

        if (existSchedule == null){
            return repository.create(schedule);
        }

        throw new RuntimeException("Такого расписания нет!");
    }

    public Schedule delete (Schedule schedule) {
        schedule.setId(schedule.getId());
        Schedule scheduleEntity = modelMapper.map(schedule, Schedule.class);
        scheduleEntity = repository.delete(schedule);
        schedule.setId(scheduleEntity.getId());
        return schedule;
    }

    //get
}

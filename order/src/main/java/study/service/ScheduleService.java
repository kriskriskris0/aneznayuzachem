package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import study.entities.BusEntity;
import study.entities.ScheduleEntity;
import study.model.Bus;
import study.model.Schedule;
import study.repository.dao.ScheduleDao;
import org.modelmapper.ModelMapper;
import study.repository.ScheduleRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleService {

    private final ScheduleRepository repository;
    @Autowired
    private ScheduleDao dao;
    private final ModelMapper modelMapper;

    public ScheduleService(ScheduleRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public String findBusByName(BusEntity bus){
        var name = repository.getBus(bus);
        if(name != null){
            return name;
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
//        Schedule scheduleEntity = modelMapper.map(schedule, Schedule.class);
        Schedule scheduleEntity = repository.delete(schedule);
        schedule.setId(scheduleEntity.getId());
        return schedule;
    }

    public List<Schedule> getAllSchedule() {
        ArrayList<Schedule> schedule = new ArrayList<>();
        for (ScheduleEntity entity: dao.findAll()) {
            schedule.add(modelMapper.map(entity, Schedule.class));
        }
        return schedule;
    }
}
package study.repository;

import org.springframework.stereotype.Component;
import study.entities.BusEntity;
import study.entities.ScheduleEntity;
import study.model.Bus;
import study.model.Schedule;
import study.repository.dao.ScheduleDao;

import java.sql.Time;

import java.util.Optional;

@Component
public class ScheduleRepository {

    private final ScheduleDao dao;

    public ScheduleRepository(ScheduleDao dao) {
        this.dao = dao;
    }

    public Schedule create(Schedule schedule) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setTime(schedule.getTime());
        scheduleEntity.setBusId(schedule.getBusId());
        scheduleEntity.setRouteId(schedule.getRouteId());
        scheduleEntity.setBusStopId(schedule.getBusStopId());

        ScheduleEntity savedEntity = dao.save(scheduleEntity);

        Schedule savedSchedule = new Schedule();
        savedSchedule.setId(savedEntity.getId());
        savedSchedule.setTime(savedEntity.getTime());
        savedSchedule.setBusId(savedEntity.getBusId());
        savedSchedule.setBusStopId(savedEntity.getBusStopId());
        savedSchedule.setRouteId(savedEntity.getRouteId());

        return savedSchedule;
    }

    //TODO гет по номеру автобуса:
    public Bus getBus(String name){

        Optional<BusEntity> optionalEntity = dao.findByName(name);

        if (optionalEntity.isPresent()) {
            BusEntity busEntity = optionalEntity.get();

            Bus savedBus = new Bus();
            savedBus.setId(busEntity.getId());
            savedBus.setName(busEntity.getName());
            savedBus.setRouteId(busEntity.getRoute());

            return savedBus;
        }

        return null;
    }
    public Schedule get(Time time) {
        Optional<ScheduleEntity> optionalEntity = dao.findByTime(time);

        if (optionalEntity.isPresent()) {
            ScheduleEntity scheduleEntity = optionalEntity.get();

            Schedule savedSchedule = new Schedule();
            savedSchedule.setId(scheduleEntity.getId());
            savedSchedule.setTime(scheduleEntity.getTime());
            savedSchedule.setBusStopId(scheduleEntity.getBusStopId());
            savedSchedule.setRouteId(scheduleEntity.getRouteId());

            return savedSchedule;
        }

        return null;
    }

    public Schedule delete(Schedule schedule){
        Optional<ScheduleEntity> delEntity = dao.findById(schedule.getId());
        dao.deleteById(delEntity.get().getId());
        return schedule;
    }

    public Schedule update(Schedule schedule){
        Optional<ScheduleEntity> existSchedule = dao.findById(schedule.getId());
        schedule.setId(schedule.getId());
        schedule.setTime(schedule.getTime());
        schedule.setBusId(schedule.getBusId());
        schedule.setBusStopId(schedule.getBusStopId());
        schedule.setRouteId(schedule.getRouteId());

        dao.save(existSchedule.get());
        return schedule;
    }
}

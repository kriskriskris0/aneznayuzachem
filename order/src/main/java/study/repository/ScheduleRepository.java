package study.repository;

import org.springframework.stereotype.Component;
import study.entities.BusEntity;
import study.entities.ScheduleEntity;
import study.model.Bus;
import study.model.Schedule;
import study.repository.dao.ScheduleDao;
import study.repository.dao.BusDao;

import java.sql.Time;

import java.util.Optional;

@Component
public class ScheduleRepository {

    private final ScheduleDao dao;
    private BusDao daobus;

    public ScheduleRepository(ScheduleDao dao) {
        this.dao = dao;
    }

    public Schedule create(Schedule schedule) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setTime(schedule.getTime());
        scheduleEntity.setBusId(schedule.getBusId());
        scheduleEntity.setRouteId(schedule.getRouteId());
        scheduleEntity.setStopId(schedule.getStopId());

        ScheduleEntity savedEntity = dao.save(scheduleEntity);

        Schedule savedSchedule = new Schedule();
        savedSchedule.setId(savedEntity.getId());
        savedSchedule.setTime(savedEntity.getTime());
        savedSchedule.setBusId(savedEntity.getBusId());
        savedSchedule.setStopId(savedEntity.getStopId());
        savedSchedule.setRouteId(savedEntity.getRouteId());

        return savedSchedule;
    }

    //TODO гет по номеру автобуса:
    public String getBus(BusEntity bus){

        Optional<BusEntity> optionalEntity = daobus.findByid(bus);

        if (optionalEntity.isPresent()) {
            BusEntity busEntity = optionalEntity.get();

            Bus savedBus = new Bus();
            savedBus.setId(busEntity.getId());
            savedBus.setName(busEntity.getName());
            savedBus.setRouteId(busEntity.getRoute());

            return savedBus.getName();
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
            savedSchedule.setStopId(scheduleEntity.getStopId());
            savedSchedule.setRouteId(scheduleEntity.getRouteId());
            savedSchedule.setBusId(scheduleEntity.getBusId());

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
        schedule.setStopId(schedule.getStopId());
        schedule.setRouteId(schedule.getRouteId());

        dao.save(existSchedule.get());
        return schedule;
    }
}


package org.repository;

import org.entities.ScheduleEntity;
import org.model.Schedule;
import org.repository.dao.ScheduleDao;

import java.sql.Time;

import java.util.Optional;

public class ScheduleRepository {

    private final ScheduleDao dao;

    public ScheduleRepository(ScheduleDao dao) {
        this.dao = dao;
    }

    public Schedule create(Schedule schedule) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setTime(schedule.getTime());
        scheduleEntity.setRouteId(schedule.getRouteId());
        scheduleEntity.setBusStopId(schedule.getBusStopId());

        ScheduleEntity savedEntity = dao.save(scheduleEntity);

        Schedule savedSchedule = new Schedule();
        savedSchedule.setId(savedEntity.getId());
        savedSchedule.setTime(savedEntity.getTime());
        savedSchedule.setBusStopId(savedSchedule.getBusStopId());
        savedSchedule.setRouteId(savedSchedule.getRouteId());

        return savedSchedule;
    }

    public Schedule get(Time time) {
        Optional<ScheduleEntity> optionalEntity = dao.findByTime(time);

        if (optionalEntity.isPresent()) {
            ScheduleEntity scheduleEntity = optionalEntity.get();

            Schedule savedSchedule = new Schedule();
            savedSchedule.setId(scheduleEntity.getId());
            savedSchedule.setTime(scheduleEntity.getTime());
            savedSchedule.setBusStopId(savedSchedule.getBusStopId());
            savedSchedule.setRouteId(savedSchedule.getRouteId());

            return savedSchedule;
        }

        return null;
    }

    public Schedule delete(Schedule schedule){
        Optional<ScheduleEntity> delEntity = dao.findById(schedule.getId());
        dao.delete(delEntity);
        return schedule;
    }

    public Schedule update(Schedule schedule){
        Optional<ScheduleEntity> existChedule = dao.findById(schedule.getId());
        schedule.setId(schedule.getId());
        schedule.setTime(schedule.getTime());
        schedule.setBusStopId(schedule.getBusStopId());
        schedule.setRouteId(schedule.getRouteId());

        ScheduleEntity findChedule = dao.delete(existChedule);
        dao.save(findChedule);
        return schedule;
    }
}

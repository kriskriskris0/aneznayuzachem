package study.repository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import study.entities.ScheduleEntity;
import study.model.Bus;
import study.model.Route;
import study.model.Schedule;
import study.model.Stop;
import study.repository.dao.BusDao;
import study.repository.dao.RouteDao;
import study.repository.dao.ScheduleDao;
import study.repository.dao.StopDao;

import java.sql.Time;

import java.util.Optional;

@Component
public class ScheduleRepository {

    private final ScheduleDao dao;
    private final RouteDao routeDao;
    private final StopDao stopDao;
    private final BusDao busDao;
    private final ModelMapper modelMapper;

    public ScheduleRepository(ScheduleDao dao, RouteDao routeDao, StopDao stopDao, BusDao busDao, ModelMapper modelMapper) {
        this.dao = dao;
        this.routeDao = routeDao;
        this.stopDao = stopDao;
        this.busDao = busDao;
        this.modelMapper = modelMapper;
    }

    public Schedule create(Schedule schedule) {
        ScheduleEntity scheduleEntity = modelMapper.map(schedule, ScheduleEntity.class);
        var routeEntity = routeDao.findById(schedule.getRoute().getId());
        scheduleEntity.setRouteId(routeEntity.get());
        var stopEntity = stopDao.findById(schedule.getStop().getId());
        scheduleEntity.setStopId(stopEntity.get());
        var busEntity = busDao.findById(schedule.getBus().getId());
        scheduleEntity.setBusId(busEntity.get());

        scheduleEntity = dao.save(scheduleEntity);
        schedule.setId(scheduleEntity.getId());

        return schedule;

//        ScheduleEntity scheduleEntity = new ScheduleEntity();
//        scheduleEntity.setTime(schedule.getTime());
//
//        BusEntity bus = new BusEntity();
//        bus.setId(schedule.getBus().getId());
//        scheduleEntity.setBusId(bus);
//
//        RouteEntity route = new RouteEntity();
//        route.setId(schedule.getRoute().getId());
//        scheduleEntity.setRouteId(route);
//
//        StopEntity stop = new StopEntity();
//        stop.setId(schedule.getStop().getId());
//        scheduleEntity.setStopId(stop);
//
//        ScheduleEntity savedEntity = dao.save(scheduleEntity);
//
//        Schedule savedSchedule = new Schedule();
//        savedSchedule.setId(savedEntity.getId());
//        savedSchedule.setTime(savedEntity.getTime());
//
//        Bus bus1 = new Bus();
//        bus1.setId(savedEntity.getBusId().getId());
//        bus1.setName(savedEntity.getBusId().getName());
//        savedSchedule.setBus(bus1);
//
//        Route route1 = new Route();
//        route1.setId(savedEntity.getRouteId().getId());
//        route1.setName(savedEntity.getRouteId().getName());
//        savedSchedule.setRoute(route1);
//
//        Stop stop1 = new Stop();
//        stop1.setId(savedEntity.getStopId().getId());
//        stop1.setAddress(savedEntity.getStopId().getAddress());
//        savedSchedule.setStop(stop1);

//        return savedSchedule;
    }

    //TODO гет по номеру автобуса:
//    public String getBusByName(String name){
//
//        Optional<ScheduleEntity> optionalEntity = dao.findByBusName(name);
//
////        if (optionalEntity.isPresent()) {
////            BusEntity busEntity = optionalEntity.get();
////
////            Bus savedBus = new Bus();
////            savedBus.setId(busEntity.getId());
////            savedBus.setName(busEntity.getName());
////            savedBus.setRouteId(busEntity.getRoute());
////
////            return savedBus.getName();
////        }
//
//        return null;
//    }
    public Schedule get(Time time) {
        Optional<ScheduleEntity> optionalEntity = dao.findByTime(time);

        if (optionalEntity.isPresent()) {
            ScheduleEntity scheduleEntity = optionalEntity.get();

            Schedule savedSchedule = new Schedule();
            savedSchedule.setId(scheduleEntity.getId());
            savedSchedule.setTime(scheduleEntity.getTime());
//            savedSchedule.setStopId(scheduleEntity.getStopId());
//            savedSchedule.setRouteId(scheduleEntity.getRouteId());
//            savedSchedule.setBusId(scheduleEntity.getBusId());

            ScheduleEntity savedEntity = dao.save(scheduleEntity);
            savedSchedule.setId(savedEntity.getId());
            savedSchedule.setTime(savedEntity.getTime());

            Bus bus1 = new Bus();
            bus1.setId(savedEntity.getBusId().getId());
            bus1.setName(savedEntity.getBusId().getName());
            savedSchedule.setBus(bus1);

            Route route1 = new Route();
            route1.setId(savedEntity.getRouteId().getId());
            route1.setName(savedEntity.getRouteId().getName());
            savedSchedule.setRoute(route1);

            Stop stop1 = new Stop();
            stop1.setId(savedEntity.getStopId().getId());
            stop1.setAddress(savedEntity.getStopId().getAddress());
            savedSchedule.setStop(stop1);

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
        schedule.setBus(schedule.getBus());
        schedule.setStop(schedule.getStop());
        schedule.setRoute(schedule.getRoute());

        dao.save(existSchedule.get());
        return schedule;
    }
}


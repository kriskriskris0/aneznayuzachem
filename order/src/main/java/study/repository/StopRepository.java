package study.repository;

import org.modelmapper.ModelMapper;
import study.entities.RouteEntity;
import study.model.Route;
import study.repository.dao.StopDao;
import study.repository.dao.RouteDao;
import study.entities.StopEntity;
import study.model.Stop;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StopRepository {

    private final StopDao dao;
    private final RouteDao routeDao;

    private final ModelMapper modelMapper;

    public StopRepository(StopDao dao, RouteDao routeDao, ModelMapper modelMapper) {
        this.dao = dao;
        this.routeDao = routeDao;
        this.modelMapper = modelMapper;
    }

    public Stop create(Stop stop) {
//1 записывает, но без связанного ключа
//        StopEntity stopEntity = modelMapper.map(stop, StopEntity.class);
//        stopEntity = dao.save(stopEntity);
//        stop.setId(stopEntity.getId());
//        return stop;


//2 ошибка 500, говорит, что getRouteId = null
        StopEntity stopEntity = modelMapper.map(stop, StopEntity.class);
        var routeEntity = routeDao.findById(stop.getRoute().getId());
        stopEntity.setRouteId(routeEntity.get());
        stopEntity = dao.save(stopEntity);
        stop.setId(stopEntity.getId());
        return stop;


//3 ошибка 500 (аналогично п.2)
//        StopEntity stopEntity = new StopEntity();
//        stopEntity.setAddress(stop.getAddress());
////        stopEntity.setRouteId(stop.getRouteId());
//
//        RouteEntity route = new RouteEntity();
//        route.setId(stop.getRoute().getId());
//        stopEntity.setRouteId(route);
//
//        StopEntity savedEntity = dao.save(stopEntity);
//
//        Stop savedStop = new Stop();
//        savedStop.setId(savedEntity.getId());
//        savedStop.setAddress(savedEntity.getAddress());
////        savedStop.setRouteId(savedEntity.getRouteId());
//
//        Route route1 = new Route();
//        route1.setId(savedEntity.getRouteId().getId());
//        route1.setName(savedEntity.getRouteId().getName());
//        savedStop.setRoute(route1);
//
//        return savedStop;


//4 аналогично п.1 и без айди
//        StopEntity newEntity = new StopEntity();
//        newEntity.setAddress(stop.getAddress());
//        newEntity.setRouteId(newEntity.getRouteId());
//
//        StopEntity savedEntity = dao.save(newEntity);
//
//        return stop;
    }

    public Stop get(String address) {
        Optional<StopEntity> optionalEntity = dao.findByAddress(address);

        if (optionalEntity.isPresent()) {
            StopEntity stopEntity = optionalEntity.get();

            Stop savedStop = new Stop();
            savedStop.setId(stopEntity.getId());
            savedStop.setAddress(stopEntity.getAddress());
//            savedStop.setRoute(stopEntity.getRouteId());
//            Route route = new Route();
//            route.setId(savedStop.getRoute());
//            route.setName(savedStop.getRoute());
//            savedStop.setRoute(route);

//            Route route1 = new Route();
//        route1.setId(savedEntity.getRouteId().getId());
//        route1.setName(savedEntity.getRouteId().getName());
//        savedSchedule.setRoute(route1);

            return savedStop;
        }

        return null;
    }

    public Stop update(Stop stop){
        Optional<StopEntity> existStop = dao.findById(stop.getId());
        stop.setId(stop.getId());
        stop.setAddress(stop.getAddress());
        stop.setRoute(stop.getRoute());

        dao.save(existStop.get());
        return stop;
    }

    public Stop delete(Stop stop) {
        Optional<StopEntity> delEntity = dao.findById(stop.getId());
        dao.deleteById(delEntity.get().getId());
        return stop;
    }
}

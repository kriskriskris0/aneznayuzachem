package org.repository;

import org.repository.dao.BusStopDao;
import org.entities.BusStopEntity;
import org.model.BusStop;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BusStopRepository {

    private final BusStopDao dao;

    public BusStopRepository(BusStopDao dao) {
        this.dao = dao;
    }

    public BusStop create(BusStop busStop) {
        BusStopEntity busStopEntity = new BusStopEntity();
        busStopEntity.setAddress(busStop.getAddress());
        busStopEntity.setRoute(busStop.getRouteId());

        BusStopEntity savedEntity = dao.save(busStopEntity);

        BusStop savedBusStop = new BusStop();
        savedBusStop.setId(savedEntity.getId());
        savedBusStop.setAddress(savedEntity.getAddress());
        savedBusStop.setRouteId(savedEntity.getRoute());

        return savedBusStop;
    }

    public BusStop get(String address) {
        Optional<BusStopEntity> optionalEntity = dao.findByAddress(address);

        if (optionalEntity.isPresent()) {
            BusStopEntity busStopEntity = optionalEntity.get();

            BusStop savedBusStop = new BusStop();
            savedBusStop.setId(busStopEntity.getId());
            savedBusStop.setAddress(busStopEntity.getAddress());
            savedBusStop.setRouteId(busStopEntity.getRoute());

            return savedBusStop;
        }

        return null;
    }

    public BusStop update(BusStop busStop){
        Optional<BusStopEntity> existBusStop = dao.findById(busStop.getId());
        busStop.setId(busStop.getId());
        busStop.setAddress(busStop.getAddress());
        busStop.setRouteId(busStop.getRouteId());

        BusStopEntity findRoute = dao.delete(existBusStop);
        dao.save(findRoute);
        return busStop;
    }


    public BusStop delete (BusStop busStop){
        Optional<BusStopEntity> delEntity = dao.findById(busStop.getId());
        dao.delete(delEntity);
        return busStop;
    }
}

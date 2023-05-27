package study.repository;

import study.repository.dao.StopDao;
import study.entities.StopEntity;
import study.model.Stop;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StopRepository {

    private final StopDao dao;

    public StopRepository(StopDao dao) {
        this.dao = dao;
    }

    public Stop create(Stop stop) {
        StopEntity stopEntity = new StopEntity();
        stopEntity.setAddress(stop.getAddress());
        stopEntity.setRouteId(stop.getRouteId());

        StopEntity savedEntity = dao.save(stopEntity);

        Stop savedStop = new Stop();
        savedStop.setId(savedEntity.getId());
        savedStop.setAddress(savedEntity.getAddress());
        savedStop.setRouteId(savedEntity.getRouteId());

        return savedStop;
    }

    public Stop get(String address) {
        Optional<StopEntity> optionalEntity = dao.findByAddress(address);

        if (optionalEntity.isPresent()) {
            StopEntity stopEntity = optionalEntity.get();

            Stop savedStop = new Stop();
            savedStop.setId(stopEntity.getId());
            savedStop.setAddress(stopEntity.getAddress());
            savedStop.setRouteId(stopEntity.getRouteId());

            return savedStop;
        }

        return null;
    }

    public Stop update(Stop stop){
        Optional<StopEntity> existStop = dao.findById(stop.getId());
        stop.setId(stop.getId());
        stop.setAddress(stop.getAddress());
        stop.setRouteId(stop.getRouteId());

        dao.save(existStop.get());
        return stop;
    }

    public Stop delete(Stop stop) {
        Optional<StopEntity> delEntity = dao.findById(stop.getId());
        dao.deleteById(delEntity.get().getId());
        return stop;
    }
}

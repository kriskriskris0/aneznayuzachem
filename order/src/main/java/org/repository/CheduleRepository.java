package org.repository;

import org.entities.CheduleEntity;
import org.entities.RouteEntity;
import org.model.Chedule;
import org.model.Route;
import org.repository.dao.CheduleDao;
import org.repository.dao.RouteDao;
import java.sql.Time;

import java.util.Optional;

public class CheduleRepository {

    private final CheduleDao dao;

    public CheduleRepository(CheduleDao dao) {
        this.dao = dao;
    }

    public Chedule create(Chedule chedule) {
        CheduleEntity cheduleEntity = new CheduleEntity();
        cheduleEntity.setTime(chedule.getTime());
        cheduleEntity.setRouteId(chedule.getRouteId());
        cheduleEntity.setBusStopId(chedule.getBusStopId());

        CheduleEntity savedEntity = dao.save(cheduleEntity);

        Chedule savedChedule = new Chedule();
        savedChedule.setId(savedEntity.getId());
        savedChedule.setTime(savedEntity.getTime());
        savedChedule.setBusStopId(savedChedule.getBusStopId());
        savedChedule.setRouteId(savedChedule.getRouteId());

        return savedChedule;
    }

    public Chedule get(Time time) {
        Optional<CheduleEntity> optionalEntity = dao.findByTime(time);

        if (optionalEntity.isPresent()) {
            CheduleEntity cheduleEntity = optionalEntity.get();

            Chedule savedChedule = new Chedule();
            savedChedule.setId(cheduleEntity.getId());
            savedChedule.setTime(cheduleEntity.getTime());
            savedChedule.setBusStopId(savedChedule.getBusStopId());
            savedChedule.setRouteId(savedChedule.getRouteId());

            return savedChedule;
        }

        return null;
    }

    public Chedule delete(Chedule chedule){
        Optional<CheduleEntity> delEntity = dao.findById(chedule.getId());
        dao.delete(delEntity);
        return chedule;
    }

    public Chedule update(Chedule chedule){
        Optional<CheduleEntity> existChedule = dao.findById(chedule.getId());
        chedule.setId(chedule.getId());
        chedule.setTime(chedule.getTime());
        chedule.setBusStopId(chedule.getBusStopId());
        chedule.setRouteId(chedule.getRouteId());

        CheduleEntity findChedule = dao.delete(existChedule);
        dao.save(findChedule);
        return chedule;
    }
}

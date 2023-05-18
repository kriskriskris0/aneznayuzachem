package org.repository;

import org.repository.dao.BusDao;
import org.entities.BusEntity;
import org.model.Bus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BusRepository {
    private final BusDao dao;

    public BusRepository(BusDao dao) {
        this.dao = dao;
    }

    public Bus create(Bus bus) {
        BusEntity busEntity = new BusEntity();
        busEntity.setName(bus.getName());

        BusEntity savedEntity = dao.save(busEntity);

        Bus savedBus = new Bus();
        savedBus.setId(savedEntity.getId());
        savedBus.setName(savedEntity.getName());

        return savedBus;
    }

    public Bus get(String name) {
        Optional<BusEntity> optionalEntity = dao.findByName(name);

        if (optionalEntity.isPresent()) {
            BusEntity busEntity = optionalEntity.get();

            Bus savedBus = new Bus();
            savedBus.setId(busEntity.getId());
            savedBus.setName(busEntity.getName());
            savedBus.setRouteId(busEntity.getRoute().getId());

            return savedBus;
        }

        return null;
    }
    public Bus delete(Bus bus) {
        Optional<BusEntity> delEntity = dao.findById(bus.getId());
        dao.delete(delEntity);
        return bus;
    }
    public Bus update(Bus bus){
        Optional<BusEntity> existBus = dao.findById(bus.getId());
        bus.setId(bus.getId());
        bus.setName(bus.getName());
        bus.setRouteId(bus.getRouteId());

        BusEntity findBus = dao.delete(existBus);
        dao.save(findBus);
        return bus;
    }

}

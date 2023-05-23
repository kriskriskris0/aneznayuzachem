package study.repository;

import study.repository.dao.BusDao;
import study.entities.BusEntity;
import study.model.Bus;
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
        busEntity.setRoute(bus.getRouteId());

        BusEntity savedEntity = dao.save(busEntity);

        Bus savedBus = new Bus();
        savedBus.setId(savedEntity.getId());
        savedBus.setName(savedEntity.getName());
        savedBus.setRouteId(savedEntity.getRoute());

        return savedBus;
    }

    public Bus get(String name) {
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
    public Bus delete(Bus bus) {
        Optional<BusEntity> delEntity = dao.findById(bus.getId());
        dao.deleteById(delEntity.get().getId());
        return bus;
    }
    public Bus update(Bus bus){
        Optional<BusEntity> existBus = dao.findById(bus.getId());
        bus.setId(bus.getId());
        bus.setName(bus.getName());
        bus.setRouteId(bus.getRouteId());


        dao.save(existBus.get());
        return bus;
    }

}

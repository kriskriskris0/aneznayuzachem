package study.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import study.repository.dao.BusDao;
import study.entities.BusEntity;
import study.model.Bus;
import org.springframework.stereotype.Component;
import study.repository.dao.RouteDao;

import java.util.Optional;

@Component
public class BusRepository {
    private final BusDao dao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RouteDao routeDao;

    public BusRepository(BusDao dao, ModelMapper modelMapper, RouteDao routeDao) {
        this.dao = dao;
        this.modelMapper = modelMapper;
        this.routeDao = routeDao;
    }

    public Bus create(Bus bus) {
        BusEntity busEntity = modelMapper.map(bus, BusEntity.class);
        var routeEntity = routeDao.findById(bus.getRoute().getId());
        busEntity.setRouteId(routeEntity.get());
        busEntity = dao.save(busEntity);
        bus.setId(busEntity.getId());
        return bus;
    }

    public Bus get(String name) {
        Optional<BusEntity> optionalEntity = dao.findByName(name);

        if (optionalEntity.isPresent()) {
            BusEntity busEntity = optionalEntity.get();

            Bus savedBus = new Bus();
            savedBus.setId(busEntity.getId());
            savedBus.setName(busEntity.getName());
//            savedBus.setRouteId(busEntity.getRouteId());

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
        bus.setRoute(bus.getRoute());

        dao.save(existBus.get());
        return bus;
    }

}

package study.service;

import study.entities.BusEntity;
import study.model.Bus;
import org.modelmapper.ModelMapper;
import study.repository.BusRepository;
import study.repository.dao.BusDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BusService {

    private final BusRepository repository;

    private final BusDao dao;

    private final ModelMapper modelMapper;

    public BusService(BusRepository repository, BusDao dao, ModelMapper modelMapper) {
        this.repository = repository;
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public Bus create(Bus bus) {

        Bus existBus = repository.get(bus.getName());

        if (existBus == null) {
            return repository.create(bus);
        }

        throw new RuntimeException("Такой автобус уже есть");
    }


    public Bus update(Bus bus) {
        Bus existBus = repository.get(String.valueOf(bus.getId()));

        if (existBus == null){
            return repository.create(bus);
        }

        throw new RuntimeException("Такой автобуса нет!");
    }

    public Bus delete (Bus bus) {
        bus.setId(bus.getId());
        Bus busEntity = modelMapper.map(bus, Bus.class);
        busEntity = repository.delete(bus);
        bus.setId(busEntity.getId());
        return bus;
    }

    public Optional<Bus> getBusByName(String name) {
        Optional<BusEntity> optionalEntity = dao.findByName(name);
        return optionalEntity.map(busEntity -> modelMapper.map(busEntity, Bus.class));
    }

    public List<Bus> getAllBus() {
        ArrayList<Bus> bus = new ArrayList<>();
        for (BusEntity entity : dao.findAll()) {
            bus.add(modelMapper.map(entity, Bus.class));
        }
        return bus;
    }
}

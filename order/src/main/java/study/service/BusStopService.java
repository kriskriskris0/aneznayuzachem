package study.service;

import study.entities.BusStopEntity;
import study.model.BusStop;
import study.repository.BusStopRepository;
import study.repository.dao.BusStopDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Component
public class BusStopService {

    private final BusStopDao dao;
    private final ModelMapper modelMapper;
    private final BusStopRepository repository;

    public BusStopService(BusStopDao dao, ModelMapper modelMapper, BusStopRepository repository) {
        this.dao = dao;
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public BusStop create(BusStop busStop) {

        //TODO переделать проверку существующей остановки по адресу
        // Подсказка: Написать в нужном ДАО метод findByAddress(String address)
        BusStop existBusStop = repository.get(busStop.getAddress());

        if (existBusStop == null) {
            return repository.create(busStop);
        }

        throw new RuntimeException("Такая остановка уже есть");
    }

    public BusStop update(BusStop busStop) {
        BusStop existBusStop = repository.get(String.valueOf(busStop.getId()));

        if (existBusStop == null){
            return repository.create(busStop);
        }

        throw new RuntimeException("Такой остановки нет!");
    }

    public BusStop delete (BusStop busStop) {
        busStop.setId(busStop.getId());
        BusStop busStopEntity = modelMapper.map(busStop, BusStop.class);
        busStopEntity = repository.delete(busStop);
        busStop.setId(busStopEntity.getId());
        return busStop;
    }

    public Optional<BusStop> getBusStopByAddress(String address) {
        Optional<BusStopEntity> optionalEntity = dao.findByAddress(address);
        return optionalEntity.map(busStopEntity -> modelMapper.map(busStopEntity, BusStop.class));
    }

    public List<BusStop> getAllBusStop() {
        ArrayList<BusStop> busStop = new ArrayList<>();
        for (BusStopEntity entity : dao.findAll()) {
            busStop.add(modelMapper.map(entity, BusStop.class));
        }
        return busStop;
    }
}


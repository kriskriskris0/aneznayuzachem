package study.service;

import study.entities.StopEntity;
import study.model.Stop;
import study.repository.StopRepository;
import study.repository.dao.StopDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Component
public class StopService {

    @Autowired
    private final StopDao dao;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final StopRepository repository;

    public StopService(StopDao dao, ModelMapper modelMapper, StopRepository repository) {
        this.dao = dao;
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public Stop create(Stop stop) {

        //TODO переделать проверку существующей остановки по адресу
        // Подсказка: Написать в нужном ДАО метод findByAddress(String address)
        Stop existStop = repository.get(stop.getAddress());

        if (existStop == null) {
            return repository.create(stop);
        }

        throw new RuntimeException("Такая остановка уже есть");
    }

    public Stop update(Stop stop) {
        Stop existStop = repository.get(String.valueOf(stop.getId()));

        if (existStop == null){
            return repository.create(stop);
        }

        throw new RuntimeException("Такой остановки нет!");
    }

    public Stop delete (Stop stop) {
        stop.setId(stop.getId());
//        Stop stopEntity = modelMapper.map(stop, Stop.class);
        Stop stopEntity = repository.delete(stop);
        stop.setId(stopEntity.getId());
        return stop;
    }

    public Optional<Stop> getStopByAddress(String address) {
        Optional<StopEntity> optionalEntity = dao.findByAddress(address);
        return optionalEntity.map(stopEntity -> modelMapper.map(stopEntity, Stop.class));
    }

    public List<Stop> getAllStop() {
        ArrayList<Stop> stop = new ArrayList<>();
        for (StopEntity entity : dao.findAll()) {
            stop.add(modelMapper.map(entity, Stop.class));
        }
        return stop;
    }
}


package org.service;

import org.entities.BusEntity;
import org.model.Bus;
import org.repository.BusRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BusService {

    private final BusRepository repository;

    public BusService(BusRepository repository) {
        this.repository = repository;
    }

    public Bus create(Bus bus) {

        Bus existBus = repository.get(bus.getName());

        if (existBus == null) {
            return repository.create(bus);
        }

        throw new RuntimeException("Такой автобус уже есть");
    }


    //update
    //delete
    //get
}

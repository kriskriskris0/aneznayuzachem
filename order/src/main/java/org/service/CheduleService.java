package org.service;

import org.model.Chedule;
import org.model.Route;
import org.repository.CheduleRepository;
import org.repository.RouteRepository;

public class CheduleService {

    private final CheduleRepository repository;

    public CheduleService(CheduleRepository repository) {
        this.repository = repository;
    }

    public Chedule create(Chedule chedule) {

        //TODO переделать проверку существующего маршрута на ВРЕМЯ маршрута
        // Подсказка: Написать в нужном ДАО метод findByName(Time time) УЖЕ СДЕЛАЛ!
        Chedule existChedule = repository.get(chedule.getTime());

        if (existChedule == null) {
            return repository.create(chedule);
        }

        throw new RuntimeException("Этот Chedule уже есть");
    }


    //update
    //delete
    //get
}

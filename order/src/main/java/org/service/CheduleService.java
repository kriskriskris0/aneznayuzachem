package org.service;

import org.model.Chedule;
import org.model.Route;
import org.repository.CheduleRepository;
import org.repository.RouteRepository;
import java.sql.Time;

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

    public Chedule get(Time time){
        Chedule existChedule = repository.get(time);
        return existChedule;
    }

    public Chedule delete(Chedule chedule){
        if(chedule == null)
            throw new RuntimeException("Такого Chedule для удаления нет");
        return repository.delete(chedule);
    }
    //update
    public Chedule update(Chedule chedule){
        if(chedule == null)
            throw new RuntimeException("Такого Chedule для обновления нет");
        return repository.update(chedule);
    }
}

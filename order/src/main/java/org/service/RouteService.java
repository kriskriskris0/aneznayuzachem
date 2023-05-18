package org.service;

import org.model.Route;
import org.repository.RouteRepository;
import org.springframework.stereotype.Component;

@Component
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public Route create(Route route) {

        //TODO переделать проверку существующего маршрута на имя маршрута
        // Подсказка: Написать в нужном ДАО метод findByName(String name)
        Route existRoute = repository.get(route.getName());

        if (existRoute == null) {
            return repository.create(route);
        }

        throw new RuntimeException("Маршрут уже есть!");
    }



    //update
    //delete
    //get
}

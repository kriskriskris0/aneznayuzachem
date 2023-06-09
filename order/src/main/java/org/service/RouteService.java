package org.service;

import org.entities.RouteEntity;
import org.model.Route;
import org.repository.RouteRepository;
import org.modelmapper.ModelMapper;
import org.repository.dao.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RouteDao dao;

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


    public Route update(Route route){
        Route exisRoute = repository.get(String.valueOf(route.getId()));

        if (exisRoute == null){
            return repository.create(route);
        }

        throw new RuntimeException("Маршрут пустой!");
    }

    public Route delete (Route route){

        route.setId(route.getId());
        Route routeEntity = modelMapper.map(route, Route.class);
        routeEntity = routeRepository.delete(route);
        route.setId(routeEntity.getId());
        return route;
    }

    public Optional<Route> getName(String name) {
        Optional<RouteEntity> optionalEntity = dao.findByName(name);
        return optionalEntity.map(routeEntity -> modelMapper.map(routeEntity, Route.class));
    }


    //update
    //delete
    //get
}

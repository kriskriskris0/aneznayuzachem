package org.repository;

import org.repository.dao.RouteDao;
import org.entities.RouteEntity;
import org.model.Route;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.IntStream;

@Component
public class RouteRepository {

    private final RouteDao dao;

    public RouteRepository(RouteDao dao) {
        this.dao = dao;
    }

    public Route create(Route route) {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setName(route.getName());

        RouteEntity savedEntity = dao.save(routeEntity);

        Route savedRoute = new Route();
        savedRoute.setId(savedEntity.getId());
        savedRoute.setName(savedEntity.getName());

        return savedRoute;
    }

    public Route get(Long id) {
        Optional<RouteEntity> optionalEntity = dao.findById(id);

        if (optionalEntity.isPresent()) {
            RouteEntity routeEntity = optionalEntity.get();

            Route savedRoute = new Route();
            savedRoute.setId(routeEntity.getId());
            savedRoute.setName(routeEntity.getName());

            return savedRoute;
        }

        return null;
    }

    public Route update(Route route){

        Optional<RouteEntity> existRoute = dao.findById(route.getId());
        route.setId(route.getId());
        route.setName(route.getName());

        RouteEntity findRoute = dao.delete(existRoute);
        dao.save(findRoute);
        return route;
    }

    public Route delete (Route route){
//        Optional<RouteEntity> routeEnt = dao.findById(route.getId());
//        if (routeEnt.isEmpty())
//        {
//            RouteEntity delEntity = dao.delete(routeEnt);
//        }
//        return route;
            Optional<RouteEntity> delEntity = dao.findById(route.getId());
            dao.delete(delEntity);
            return route;
    }
    //update
    //delete
}

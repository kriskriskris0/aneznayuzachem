package org.repository;

import org.repository.dao.RouteDao;
import org.entities.RouteEntity;
import org.model.Route;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    //update
    //delete
}

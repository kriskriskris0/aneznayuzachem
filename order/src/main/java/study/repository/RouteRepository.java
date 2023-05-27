package study.repository;

import study.repository.dao.RouteDao;
import study.entities.RouteEntity;
import study.model.Route;
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
        routeEntity.setId(route.getId());
        routeEntity.setName(route.getName());

        RouteEntity savedEntity = dao.save(routeEntity);

        Route savedRoute = new Route();
        savedRoute.setId(savedEntity.getId());
        savedRoute.setName(savedEntity.getName());

        return savedRoute;
    }

    public Route get(String name) {
        Optional<RouteEntity> optionalEntity = dao.findByName(name);

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

        dao.save(existRoute.get());
        return route;
    }

    public Route delete (Route route){
        Optional<RouteEntity> delEntity = dao.findById(route.getId());
        dao.deleteById(delEntity.get().getId());
        return route;
    }
}

package org.repository.dao;

import org.entities.RouteEntity;
import org.repository.RouteRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RouteDao extends CrudRepository<RouteEntity, Long> {


    RouteEntity delete(Optional<RouteEntity> routeEnt);

    RouteEntity findAll(RouteEntity routeEntity);

    Optional<RouteEntity> findByName(String name);
}

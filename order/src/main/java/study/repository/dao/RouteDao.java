package study.repository.dao;

import org.springframework.data.repository.CrudRepository;
import study.entities.RouteEntity;

import java.util.Optional;

public interface RouteDao extends CrudRepository<RouteEntity, Long> {

//    RouteEntity findAll(RouteEntity routeEntity);

    Optional<RouteEntity> findByName(String name);
}

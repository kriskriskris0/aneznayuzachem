package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleDao extends CrudRepository<ScheduleEntity, Long> {

    List<ScheduleEntity> findAllByRouteId(Long routeId);

}

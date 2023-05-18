package org.repository.dao;

import org.entities.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.Optional;

public interface ScheduleDao extends CrudRepository<ScheduleEntity, Long> {


    ScheduleEntity delete(Optional<ScheduleEntity> delEntity);

    Optional<ScheduleEntity> findByTime(Time time);
}

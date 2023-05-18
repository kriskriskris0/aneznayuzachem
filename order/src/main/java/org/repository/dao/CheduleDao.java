package org.repository.dao;

import org.entities.CheduleEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.Optional;

public interface CheduleDao extends CrudRepository<CheduleEntity, Long> {


    CheduleEntity delete(Optional<CheduleEntity> delEntity);

    Optional<CheduleEntity> findByTime(Time time);
}

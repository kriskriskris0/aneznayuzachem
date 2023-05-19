package org.repository.dao;

import org.entities.BusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BusDao extends CrudRepository<BusEntity, Long>{
    BusEntity delete(Optional<BusEntity> busEntity);
    Optional<BusEntity>  findByName(String name);
}

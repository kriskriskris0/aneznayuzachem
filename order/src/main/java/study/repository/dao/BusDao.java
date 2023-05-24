package study.repository.dao;

import study.entities.BusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BusDao extends CrudRepository<BusEntity, Long>{
    Optional<BusEntity>  findByName(String name);
    Optional<BusEntity> findByid(BusEntity bus);
}

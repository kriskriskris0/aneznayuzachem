package study.repository.dao;

import study.entities.StopEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface StopDao extends CrudRepository<StopEntity, Long> {
    Optional<StopEntity> findByAddress(String address);
}

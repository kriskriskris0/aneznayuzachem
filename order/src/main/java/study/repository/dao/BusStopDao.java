package study.repository.dao;

import study.entities.BusStopEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BusStopDao extends CrudRepository<BusStopEntity, Long> {
    BusStopEntity delete(Optional<BusStopEntity> busStopEntity);
    Optional<BusStopEntity> findByAddress(String address);
}

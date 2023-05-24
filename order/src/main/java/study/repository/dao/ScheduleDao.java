package study.repository.dao;

import study.entities.BusEntity;
import study.entities.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.Optional;

public interface ScheduleDao extends CrudRepository<ScheduleEntity, Long> {

    Optional<ScheduleEntity> findByTime(Time time);

    Optional<BusEntity> findByBusId(BusEntity bus);

    Optional<BusEntity> findByName(String name);
}

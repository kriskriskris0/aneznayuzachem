package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<BusEntity, Long> {

    List<BusEntity> findAllByClientId(Long clientId);

    List<BusEntity> findAllByClientIdIn(List <Long> clientId);
}

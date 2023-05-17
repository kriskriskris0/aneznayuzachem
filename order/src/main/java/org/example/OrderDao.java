package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByClientId(Long clientId);

    List<OrderEntity> findAllByClientIdIn(List <Long> clientId);
}

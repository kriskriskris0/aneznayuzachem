package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<BusEntity, Long> {


}

package com.gfa.takeout.repositories;

import com.gfa.takeout.models.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
  List<Order> getByStatus(String status);
}

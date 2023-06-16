package com.gfa.takeout.services;

import com.gfa.takeout.models.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {

  Order save (Order order);

  Optional<Order> getById(Long id);

  List<Order> getByStatus(String status);

  void editStatus(Order order, String status);

  boolean isValidStatus(String status);
}

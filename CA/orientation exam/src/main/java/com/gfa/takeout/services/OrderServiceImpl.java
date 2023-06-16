package com.gfa.takeout.services;

import com.gfa.takeout.models.Order;
import com.gfa.takeout.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final List<String> statuses = List.of("ordered", "inprogress", "done");
  private final OrderRepository orderRepository;

  @Autowired
  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order save(Order order) {
    if (order.getStatus() == null || order.getStatus().isEmpty()) {
      order.setStatus("ordered");
    }
    return orderRepository.save(order);
  }

  @Override
  public Optional<Order> getById(Long id) {
    return orderRepository.findById(id);
  }

  @Override
  public List<Order> getByStatus(String status) {
    return orderRepository.getByStatus(status);
  }

  @Override
  public void editStatus(Order order, String status) {
    order.setStatus(status);
    save(order);
  }

  @Override
  public boolean isValidStatus(String status) {
    return statuses.contains(status.toLowerCase());
  }
}

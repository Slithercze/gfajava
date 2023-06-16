package com.gfa.takeout.controllers;

import com.gfa.takeout.models.dtos.EditStatusRequestDto;
import com.gfa.takeout.services.OrderService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gfa.takeout.models.Order;

@RestController
@RequestMapping("/api/orders")
public class ApiControllers {

  private final OrderService orderService;

  @Autowired
  public ApiControllers(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<?> saveOrder(@RequestBody Order order) {
    return ResponseEntity.ok(orderService.save(order));
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<?> getById(@PathVariable Long orderId) {
    Optional<Order> maybeOrder = orderService.getById(orderId);
    if (maybeOrder.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(maybeOrder.get());
  }

  @GetMapping
  public ResponseEntity<?> getByStatus(@RequestParam String status) {
    if (!orderService.isValidStatus(status)) {
      return ResponseEntity.status(422).build();
    }
    return ResponseEntity.ok(orderService.getByStatus(status));
  }

  @PatchMapping("/{orderId}")
  public ResponseEntity<?> editStatus(@RequestBody EditStatusRequestDto dto, @PathVariable Long orderId) {
    if (!orderService.isValidStatus(dto.getStatus())) {
      return ResponseEntity.status(422).build();
    }

    Optional<Order> maybeOrder = orderService.getById(orderId);
    if (maybeOrder.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    orderService.editStatus(maybeOrder.get(), dto.getStatus());

    return ResponseEntity.ok().build();
  }

}

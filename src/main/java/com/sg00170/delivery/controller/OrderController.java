package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Order;
import com.sg00170.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    // 주문 생성
    @PostMapping
    public Long createOrder(@RequestBody Order order) {
        // 소비자 ID, 결제 수단, 배달 주소, 배달 시각, 음식점 ID, 주문 품목
        return orderService.saveOrder(order);
    }
}

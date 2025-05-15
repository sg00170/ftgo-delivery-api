package com.sg00170.delivery.service;

import com.sg00170.delivery.exception.NotFoundException;
import com.sg00170.delivery.model.OrderItem;
import com.sg00170.delivery.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OrderItem not found"));
    }
}

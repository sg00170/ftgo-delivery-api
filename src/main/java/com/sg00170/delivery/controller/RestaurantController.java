package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Restaurant;
import com.sg00170.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantService.findRestaurantById(id);
    }

    // 주문 접수
    @PostMapping("/orders/{id}")
    public void acceptOrder() {
        // 식당 ID, 주문 ID, readyTime
    }

    // 주문 픽업 준비됨
    @PatchMapping("/orders/{id}/pick-up")
    public boolean noteOrderReadyForPickup() {
        return true;
    }
}

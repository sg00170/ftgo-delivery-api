package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Restaurant;
import com.sg00170.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    // 현재 사용가능한 음식점 목록
    @GetMapping("/available")
    public List<Restaurant> findAvailableRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // 주문 확인
    @PostMapping("/orders/{id}/verification")
    public boolean verifyOrderDetails() {
        return true;
    }
}

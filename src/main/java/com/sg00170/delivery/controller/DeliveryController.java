package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Delivery;
import com.sg00170.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable Long id) {
        return deliveryService.findDeliveryById(id);
    }

    // 배달 스케쥴 생성
    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    // 위치 업데이트
    @PatchMapping("/{id}/location")
    public void noteUpdatedLocation() {
    }

    // 배달 픽업 업데이트
    @PatchMapping("/{id}/pick-up")
    public void noteDeliveryPickedUp() {
    }

    // 주문 배달
    @PatchMapping("/{id}/delivery")
    public void noteDeliveryDelivered() {
    }
}

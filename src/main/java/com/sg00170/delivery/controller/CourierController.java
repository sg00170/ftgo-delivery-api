package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Courier;
import com.sg00170.delivery.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public Courier getCourier(@PathVariable Long id) {
        return courierService.findCourierById(id);
    }

    // 위치 업데이트
    @PatchMapping("/{id}/location")
    public boolean noteUpdatedLocation() {
        return true;
    }

    // 배달 픽업 업데이트
    @PatchMapping("/{id}/pick-up")
    public boolean noteDeliveryPickedUp() {
        return true;
    }

    // 주문 배달
    @PatchMapping("/{id}/delivery")
    public boolean noteDeliveryDelivered() {
        return true;
    }
}

package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Courier;
import com.sg00170.delivery.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

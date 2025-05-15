package com.sg00170.delivery.service;

import com.sg00170.delivery.exception.NotFoundException;
import com.sg00170.delivery.model.Courier;
import com.sg00170.delivery.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    public Courier findById(Long id) {
        return courierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Courier not found"));
    }
}

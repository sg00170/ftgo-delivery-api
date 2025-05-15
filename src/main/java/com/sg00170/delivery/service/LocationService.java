package com.sg00170.delivery.service;

import com.sg00170.delivery.exception.NotFoundException;
import com.sg00170.delivery.model.Location;
import com.sg00170.delivery.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location findById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found"));
    }
}

package com.sg00170.delivery.repository;

import com.sg00170.delivery.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}

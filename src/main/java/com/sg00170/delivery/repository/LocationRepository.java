package com.sg00170.delivery.repository;

import com.sg00170.delivery.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

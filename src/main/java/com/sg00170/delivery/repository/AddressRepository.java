package com.sg00170.delivery.repository;

import com.sg00170.delivery.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

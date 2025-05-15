package com.sg00170.delivery.repository;

import com.sg00170.delivery.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

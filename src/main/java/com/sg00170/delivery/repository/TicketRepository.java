package com.sg00170.delivery.repository;

import com.sg00170.delivery.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

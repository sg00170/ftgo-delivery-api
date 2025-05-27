package com.sg00170.delivery.repository;

import com.sg00170.delivery.model.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketItemRepository extends JpaRepository<TicketItem, Long> {
}

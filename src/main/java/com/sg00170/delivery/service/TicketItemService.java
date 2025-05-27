package com.sg00170.delivery.service;

import com.sg00170.delivery.exception.NotFoundException;
import com.sg00170.delivery.model.TicketItem;
import com.sg00170.delivery.repository.TicketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketItemService {

    @Autowired
    private TicketItemRepository ticketItemRepository;

    public List<TicketItem> getAllTicketItems() {
        return ticketItemRepository.findAll();
    }

    public TicketItem findTicketItemById(Long id) {
        return ticketItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TicketItem not found"));
    }
}

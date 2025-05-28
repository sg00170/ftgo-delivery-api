package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Ticket;
import com.sg00170.delivery.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.findTicketById(id);
    }

    // 티켓 생성
    @PostMapping
    public Long createTicket(@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    // 주문 접수
    @PostMapping("/orders/{id}")
    public void acceptOrder() {
        // 식당 ID, 주문 ID, readyTime
    }

    // 주문 픽업 준비됨
    @PatchMapping("/orders/{id}/pick-up")
    public void noteOrderReadyForPickup() {
    }
}

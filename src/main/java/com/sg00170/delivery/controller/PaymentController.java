package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.Payment;
import com.sg00170.delivery.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }

    // 카드 인증
    @PostMapping("cards")
    public boolean authorizeCard() {
        return true;
    }
}

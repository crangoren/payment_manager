package com.pet.budget_manager.controllers;

import com.pet.budget_manager.dto.PaymentDto;
import com.pet.budget_manager.entities.Payment;
import com.pet.budget_manager.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDto paymentDto){
        Payment payment = paymentService.createPayment(paymentDto.getTitle(), paymentDto.isCompleted(), paymentDto.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Payment> updatePayment(@RequestBody PaymentDto paymentDto) {
        Payment payment = paymentService.updatePayment(paymentDto.getId(), paymentDto.getTitle(), paymentDto.isCompleted(), paymentDto.getAmount());
        return ResponseEntity.ok(payment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePaymentById(@PathVariable("id") Long id){
        paymentService.deletePaymentById(id);
    }
}

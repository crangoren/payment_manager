package com.pet.budget_manager.services.impl;

import com.pet.budget_manager.entities.Payment;
import com.pet.budget_manager.repositories.PaymentRepository;
import com.pet.budget_manager.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(String title, boolean isCompleted, long amount) {
        Payment payment = mapPayment(title, isCompleted, amount);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, String title, boolean isCompleted, long amount) {
        Payment payment = mapPayment(title, isCompleted, amount);
        payment.setId(id);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    private Payment mapPayment(String title, boolean isCompleted, long amount){
        Payment payment = new Payment();
        payment.setCompleted(isCompleted);
        payment.setTitle(title);
        payment.setCreationDate(LocalDate.now());
        payment.setAmount(amount);
        return payment;
    }


}

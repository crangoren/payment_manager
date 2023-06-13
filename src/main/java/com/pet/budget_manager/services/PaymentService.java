package com.pet.budget_manager.services;

import com.pet.budget_manager.entities.Payment;


public interface PaymentService {
    Payment createPayment(String title, boolean isCompleted, long amount);

    Payment updatePayment(Long id, String title, boolean completed, long amount);

    Payment getPaymentById(Long id);

    void deletePaymentById(Long id);
}

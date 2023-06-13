package com.pet.budget_manager.repositories;

import com.pet.budget_manager.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

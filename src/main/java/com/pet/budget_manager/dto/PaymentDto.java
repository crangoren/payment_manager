package com.pet.budget_manager.dto;

import lombok.Data;

@Data
public class PaymentDto {

    private Long id;
    private String title;
    private Long amount;

    private boolean isCompleted;
}

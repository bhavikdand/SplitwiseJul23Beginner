package com.example.splitwiseJul23Beginner.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ExpenseUserOwedBy  extends BaseModel{
    private Expense expense;
    private User user;
    private double amount;
}
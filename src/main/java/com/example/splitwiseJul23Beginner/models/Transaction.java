package com.example.splitwiseJul23Beginner.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Transaction extends BaseModel{
    private int paid;
    private int owed;
    private double amount;
}

package com.example.splitwiseJul23Beginner.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Group extends BaseModel{
    private String name;
    private List<Expense> expenses;
    private List<User> users;
    private List<User> admins;
    private List<Transaction> transactions;
}

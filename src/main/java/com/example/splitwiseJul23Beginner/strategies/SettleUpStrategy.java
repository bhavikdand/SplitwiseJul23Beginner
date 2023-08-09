package com.example.splitwiseJul23Beginner.strategies;

import com.example.splitwiseJul23Beginner.models.Expense;
import com.example.splitwiseJul23Beginner.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {

    List<Transaction> settle(List<Expense> expenses);
}

package com.example.splitwiseJul23Beginner.repository;

import com.example.splitwiseJul23Beginner.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByIdIn(List<Integer> expenseIds);

}

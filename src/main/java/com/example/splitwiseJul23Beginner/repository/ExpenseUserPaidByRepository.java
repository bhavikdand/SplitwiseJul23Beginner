package com.example.splitwiseJul23Beginner.repository;

import com.example.splitwiseJul23Beginner.models.ExpenseUserPaidBy;
import com.example.splitwiseJul23Beginner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserPaidByRepository extends JpaRepository<ExpenseUserPaidBy, Integer> {
    List<ExpenseUserPaidBy> findAllByUser(User user);
}

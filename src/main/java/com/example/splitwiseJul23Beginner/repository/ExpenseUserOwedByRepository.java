package com.example.splitwiseJul23Beginner.repository;

import com.example.splitwiseJul23Beginner.models.ExpenseUserOwedBy;
import com.example.splitwiseJul23Beginner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserOwedByRepository extends JpaRepository<ExpenseUserOwedByRepository, Integer> {

    List<ExpenseUserOwedBy> findAllByUser(User user);
}

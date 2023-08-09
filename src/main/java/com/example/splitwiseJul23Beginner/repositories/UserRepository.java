package com.example.splitwiseJul23Beginner.repositories;

import com.example.splitwiseJul23Beginner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    User findById(int userId);
}

package com.example.splitwiseJul23Beginner.repository;

import com.example.splitwiseJul23Beginner.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Group findById(int groupId);
}

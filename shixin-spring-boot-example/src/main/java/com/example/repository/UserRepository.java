package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shixin
 * @date 2021/2/27
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}

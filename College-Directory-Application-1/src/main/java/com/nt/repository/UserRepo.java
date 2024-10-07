package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
public User findByUsernameAndPassword(String username,String password);
}

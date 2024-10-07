package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.StudentProfile;

public interface StudentRepo extends JpaRepository<StudentProfile, Long> {
	 public StudentProfile findByUserId(Long userId);
}

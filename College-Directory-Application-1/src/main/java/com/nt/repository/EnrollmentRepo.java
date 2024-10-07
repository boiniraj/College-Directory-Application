package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

}

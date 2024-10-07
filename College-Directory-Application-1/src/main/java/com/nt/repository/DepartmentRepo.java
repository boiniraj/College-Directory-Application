package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}

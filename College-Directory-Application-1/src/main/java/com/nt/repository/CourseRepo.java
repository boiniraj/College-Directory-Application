package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}

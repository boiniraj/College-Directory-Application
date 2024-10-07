package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.FacultyProfile;

public interface FacultyRepo extends JpaRepository<FacultyProfile, Long> {

}

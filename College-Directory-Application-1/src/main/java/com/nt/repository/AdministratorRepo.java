package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.AdministratorProfile;

public interface AdministratorRepo extends JpaRepository<AdministratorProfile, Long> {

}

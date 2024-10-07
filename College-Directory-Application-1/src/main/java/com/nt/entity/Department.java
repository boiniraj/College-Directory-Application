package com.nt.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Department")
@Data

public class Department {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 100)
	    private String name;

	    @Column(length=100)
	    private String description;
	

	    // One-to-Many relationship with StudentProfile
	    @OneToMany(mappedBy = "department")
	    @JsonManagedReference
	    private Set<StudentProfile> students;

	    

	   @OneToMany(mappedBy="department")
	   @JsonManagedReference
	    private Set<FacultyProfile> facultyMembers;

	    // One-to-Many relationship with AdministratorProfile
	    @OneToMany(mappedBy = "department")
	    private Set<AdministratorProfile> administrators;

	    // One-to-Many relationship with Course
	    @OneToMany(mappedBy = "department")
	    private Set<Course> courses;
}

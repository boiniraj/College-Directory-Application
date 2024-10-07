package com.nt.entity;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "StudentProfile")
@Setter
@Getter

public class StudentProfile  {
	   @Id
	   @Column(name = "user_id",insertable=false, updatable=false)
	    private Long userId;
	   
	    @Column(length = 150)
	    private String photo;
	    
	    @NotNull
	    @Column(name = "department_id",insertable=false, updatable=false)
	    private Long departmentId;

	    @Column(length = 50, nullable = false)
	    private String year;

	    // Many-to-One relationship with Department
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "department_id", referencedColumnName = "id",nullable = false)
	    @JsonBackReference
	    private Department department;

	    // One-to-One relationship with User
	    @OneToOne(fetch = FetchType.EAGER) /*(mappedBy="profile",fetch=FetchType.LAZY)*/
		@MapsId
	    @JoinColumn(name="user_id",referencedColumnName = "id", insertable = false, updatable = false)
	    private User user;
}

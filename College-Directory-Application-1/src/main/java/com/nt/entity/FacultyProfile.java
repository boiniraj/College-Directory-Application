package com.nt.entity;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FacultyProfile")
@Setter
@Getter
public class FacultyProfile {
	  
    @Id
   @Column(name = "user_id")
    private Long userId;

    @Column(length = 100)
    private String photo;
    
    @NotNull
    @Column(name = "department_id",insertable=false, updatable=false)
    private Long departmentId; 

    @Column(length = 100)
    private String officeHours;

    // One-to-One relationship with User
   
 
	/*@OneToOne(mappedBy="facultyprofile")*/
    @OneToOne
    @MapsId
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    // Many-to-One relationship with Department
   

   @ManyToOne
   @JoinColumn(name = "department_id",  referencedColumnName = "id",nullable=false)
   @JsonBackReference
    private  Department department;

}

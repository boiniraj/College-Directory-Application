package com.nt.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Course")
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @NotNull
    @Column(nullable = false, length = 100)
    private String title;

    @Column(length=100)
    private String description;
    @NotNull
    @Column(name = "department_id",insertable=false, updatable=false)
    private Long departmentId;
    
    @NotNull
    @Column(name = "faculty_id",insertable=false, updatable=false)
    private Long facultyId;
    
    // Many-to-One relationship with Department
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
    private Department department;

    // Many-to-One relationship with FacultyProfile
    @ManyToOne//many courses can be taught by one faculty member
    @JoinColumn(name = "faculty_id", nullable = false,referencedColumnName = "user_id")
    private FacultyProfile faculty;
}

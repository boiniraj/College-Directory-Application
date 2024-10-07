package com.nt.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Enrollment")
@Data
public class Enrollment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "student_id",insertable=false, updatable=false)
	    private Long studentId;
	    @NotNull
	    @Column(name = "course_id",insertable=false, updatable=false)
	    private Long courseId;

	    // Many-to-One relationship with StudentProfile
	    @ManyToOne
	    @JoinColumn(name = "student_id",referencedColumnName = "user_id", nullable = false)
	    private StudentProfile student;

	    // Many-to-One relationship with Course
	    @ManyToOne
	    @JoinColumn(name = "course_id",referencedColumnName = "id", nullable = false)
	    @MapsId
	    private Course course;

}

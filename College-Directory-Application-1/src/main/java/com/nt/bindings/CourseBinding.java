package com.nt.bindings;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseBinding {
	private String title; // Title of the course
    private String description; // Description of the course
    private Long departmentId; // ID of the department
    private Long facultyId; // ID of the faculty member

}

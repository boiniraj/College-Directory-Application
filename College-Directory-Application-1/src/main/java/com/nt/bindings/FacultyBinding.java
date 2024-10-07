package com.nt.bindings;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FacultyBinding {
	private Long userId;        // Foreign key linking to the User entity
    private String photo;       // URL or path to the faculty member's profile photo
    private Long departmentId;  // Foreign key linking to the Department entity
    private String officeHours; // Office hours for the faculty member

}

package com.nt.bindings;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class StudentBinding {
	  
	// Foreign key linking to the User entity, mandatory field
   
   private Long userId;

    // URL or path to the student's profile photo
    
    private String photo;

    // Foreign key linking to the Department entity, mandatory field
    
     private Long departmentId;

    // Year of study (e.g., Freshman, Sophomore, etc.), mandatory field
    
    private String year;
}

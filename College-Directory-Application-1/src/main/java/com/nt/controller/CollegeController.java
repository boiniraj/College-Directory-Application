package com.nt.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.AdminiStratorBinding;
import com.nt.bindings.CourseBinding;
import com.nt.bindings.DepartmentBinding;
import com.nt.bindings.EnrollmentBinding;
import com.nt.bindings.FacultyBinding;
import com.nt.bindings.LoginRequest;
import com.nt.bindings.LoginResponse;
import com.nt.bindings.StudentBinding;
import com.nt.bindings.UserBinding;
import com.nt.entity.AdministratorProfile;
import com.nt.entity.Course;
import com.nt.entity.Department;
import com.nt.entity.Enrollment;
import com.nt.entity.FacultyProfile;
import com.nt.entity.StudentProfile;
import com.nt.entity.User;
import com.nt.repository.UserRepo;
import com.nt.service.ICollegeService;

@RestController
@RequestMapping("/college-api")
public class CollegeController {
	@Autowired
	private ICollegeService service;
	@Autowired
	private UserRepo userRepo;

	/*@PostMapping("/register-user")
	public ResponseEntity<User>RegisterUser(@RequestBody  RegistrationRequest registrationRequest)
	{
		 UserBinding ubindings = registrationRequest.getUserBinding();
		    StudentBinding sbinding = registrationRequest.getStudentBinding();
	
		    User ruser = service.registerUserwithStudent(ubindings, sbinding);
		    return new ResponseEntity<>(ruser, HttpStatus.CREATED);
	}
	
	@PostMapping("/register-department")
	public ResponseEntity<Department> RegisterDepartment(@RequestBody DepartmentBinding dbindings)
	{
		Department rdept=service.registeDepartment(dbindings);
		return new ResponseEntity<Department>(rdept,HttpStatus.CREATED);
	}
	@PostMapping("/register-student")
	public ResponseEntity<StudentProfile> RegisterStudent(@RequestBody StudentBinding sbinding)
	{
		StudentProfile rstudent=service.registerStudent(sbinding);
		return new ResponseEntity<StudentProfile>(rstudent,HttpStatus.CREATED);
	}
	@GetMapping("/showAllUsers")
	public ResponseEntity<List<User>> showAllUsers()
	{
		List<User >user1=service.showAllUsers();
		return new ResponseEntity<List<User>>(user1,HttpStatus.CREATED);
	}
	@PostMapping("/register-user-with-facuclty")
	public ResponseEntity<FacultyProfile> UserregisterWithFaculty(@RequestBody RegistrationRequest1 request1 )
	{
		UserBinding ubinding1=request1 .getUbinding();
		FacultyBinding fbinding=request1.getFbinding();
		FacultyProfile fprofile=service.registerUserWithFaculty(ubinding1, fbinding);
		return new ResponseEntity<FacultyProfile>(fprofile,HttpStatus.CREATED);
		
	}*/
	
	@PostMapping("/register-department")
	public ResponseEntity<Department> RegisterDepartment(@RequestBody DepartmentBinding binding)
	{
		Department dept=service.registerDepartment(binding);
		return new ResponseEntity<Department>(dept,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/register-user")
	public ResponseEntity<User> RegisterUser(@RequestBody UserBinding ubinding)
	{
		 User user=service.registerUser(ubinding);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	@PostMapping("/register-student")
	public ResponseEntity<StudentProfile> RegisterStudent( @RequestBody StudentBinding sbinding) throws RoleNotFoundException
	{ 
		StudentProfile sprofile=service.registerStudent(sbinding) ;
		return new ResponseEntity<StudentProfile>(sprofile,HttpStatus.CREATED);
	}
	
	@PostMapping("/register-faculty")
	public ResponseEntity<FacultyProfile> RegisterFaculty( @RequestBody FacultyBinding fbinding) throws RoleNotFoundException
	{ 
		FacultyProfile fprofile=service.registerFaculty(fbinding);
		return new ResponseEntity<FacultyProfile>(fprofile,HttpStatus.CREATED);
	}
	
	@PostMapping("/register-AdminiStrator")
	public ResponseEntity<AdministratorProfile> RegisterAdminiStrator( @RequestBody  AdminiStratorBinding abinding) throws RoleNotFoundException
	{ 
		 AdministratorProfile aprofile=service.registerAdminiStrator(abinding);
		return new ResponseEntity<AdministratorProfile>(aprofile,HttpStatus.CREATED);
	}
	

	@GetMapping("/showAll")
	public ResponseEntity<List<StudentProfile>> showAll()
	{
		List<StudentProfile> profile=service.showAllStudents();
		return new ResponseEntity<List<StudentProfile>>(profile,HttpStatus.OK);
	}
	@PostMapping("/register-course")
	public ResponseEntity<Course> RegisterCourse(@RequestBody CourseBinding cbinding)
	{
		Course course=service.registerCourse(cbinding);
		return new ResponseEntity<Course>(course,HttpStatus.CREATED);
	}
	@PostMapping("/register-enrollment")
	public ResponseEntity<Enrollment>RegisterEnrollment(@RequestBody EnrollmentBinding ebinding)
	{
		Enrollment enrollment=service.registerEnrollment(ebinding);
		return new ResponseEntity<Enrollment>(enrollment,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
	{
		try {
			User  user=service.login(loginRequest.getUsername(), loginRequest.getPassword());
			 return ResponseEntity.ok(user);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
	
	/*@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	    Optional<User> userOpt = userRepo.findByUsernameAndPassword(
	        loginRequest.getUsername(), 
	        loginRequest.getPassword()
	    );
	    
	    if (userOpt.isPresent()) {
	        User user = userOpt.get();
	        return ResponseEntity.ok(new LoginResponse(user.getRole()));
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
	}*/
	
	
	 @GetMapping("/student/{userId}")
	    public ResponseEntity<?> getStudentProfile(@PathVariable Long userId) {
	        StudentProfile profile = service.getStudentProfile(userId);
	        return ResponseEntity.ok(profile);
	    }

}

package com.nt.service;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bindings.AdminiStratorBinding;
import com.nt.bindings.CourseBinding;
import com.nt.bindings.DepartmentBinding;
import com.nt.bindings.EnrollmentBinding;
import com.nt.bindings.FacultyBinding;
import com.nt.bindings.Role;
import com.nt.bindings.StudentBinding;
import com.nt.bindings.UserBinding;
import com.nt.entity.AdministratorProfile;
import com.nt.entity.Course;
import com.nt.entity.Department;
import com.nt.entity.Enrollment;
import com.nt.entity.FacultyProfile;
import com.nt.entity.StudentProfile;
import com.nt.entity.User;
import com.nt.repository.AdministratorRepo;
import com.nt.repository.CourseRepo;
import com.nt.repository.DepartmentRepo;
import com.nt.repository.EnrollmentRepo;
import com.nt.repository.FacultyRepo;
import com.nt.repository.StudentRepo;
import com.nt.repository.UserRepo;

@Service
public class CollegeServiceImpl implements ICollegeService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private FacultyRepo facultyRepo;
	@Autowired
	private  AdministratorRepo AdminRepo;
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private EnrollmentRepo enrollmentRepo;

	/*@Override
		public User registerUserwithStudent(UserBinding ubinding, StudentBinding sbinding) {
			User user = new User();
			BeanUtils.copyProperties(ubinding, user);
			user.setRole(Role.valueOf(ubinding.getRole().name().toUpperCase()));
	
			if ( ubinding.getRole().equals(user.getRole().STUDENT))
					{
				// create child object
				StudentProfile student = new StudentProfile();
				student.setPhoto(sbinding.getPhoto());
				student.setYear(sbinding.getYear());
				Department department = departmentRepo.findById(sbinding.getDepartmentId())
						.orElseThrow(() -> new IllegalArgumentException("Department not found"));
				student.setDepartment(department);
					
				
				// add child to parent
				student.setUser(user);
				// add parent to child
				user.setProfile(student);
					}
			// save the parent object
			return userRepo.save(user);
		}*/


	@Override
	
	public Department registerDepartment(DepartmentBinding dbindings) {
		Department dept = new Department();
		BeanUtils.copyProperties(dbindings, dept);
		return departmentRepo.save(dept);
	}
	/*
	@Override
	public List<User> showAllUsers() {
		
		List<User> user=userRepo.findAll();
		
		return user ;
	}
	
	
	@Override
	public FacultyProfile registerUserWithFaculty(UserBinding ubinding, FacultyBinding fbinding) {
		  User user2=new User();
		  BeanUtils.copyProperties(ubinding, user2);
		  user2.setRole(Role.valueOf(ubinding.getRole().name().toUpperCase()));
		userRepo.save(user2);
		  
		  FacultyProfile fprofile=null;
		  if(ubinding.getRole()==user2.getRole().FACULTY_MEMBER)
		  {
	 fprofile=new  FacultyProfile();
				Department department = departmentRepo.findById(fbinding.getDepartmentId())
						.orElseThrow(() -> new IllegalArgumentException("Department not found"));
				
			  fprofile.setPhoto(fbinding.getPhoto());
			  fprofile.setDepartment(department);
			  fprofile.setOfficeHours(fbinding.getOfficeHours()); 
			  //parent to child
			  fprofile.setUser(user2);
			  //child to parent
			  user2.setFacultyprofile(fprofile);  
		  }  
		  return facultyRepo.save(fprofile);
	}*/

//////////////////////////////////////////////////////////
	@Override
	public User registerUser(UserBinding user) {
		User user1=new User();
		BeanUtils.copyProperties(user, user1);
		 user1.setRole(Role.valueOf(user.getRole().name().toUpperCase()));
		return userRepo.save(user1);
	}
	
	//student
	@Override
	public StudentProfile registerStudent( StudentBinding sbinding) throws RoleNotFoundException
	{
		/*Optional<User> optuser2=userRepo.findById(sbinding.getUserId());*/
		 User user = userRepo.findById(sbinding.getUserId())
                 .orElseThrow(() -> new RuntimeException("User not found"));
		Department  dept=departmentRepo.findById(sbinding.getDepartmentId())
				.orElseThrow(() -> new RuntimeException("department id not found"));
		
		/*if(optuser2.isPresent() && optdpt.isPresent() ) {*/
			
			/*User use3=optuser2.get();
			Long uid=use3.getId();
			Department dpt=optdpt.get();
			Long deptid=dpt.getId();*/
		StudentProfile student=null;
		if(user.getRole()==Role.STUDENT)
		{
		 student=new StudentProfile();
		
		//student.setUserId(sbinding.getUserId());
		student.setUser(user);
		student.setDepartment(dept);
		//student.setDepartmentId(dept.getId());
		student.setPhoto(sbinding.getPhoto());
		student.setYear(sbinding.getYear());
		}
		else {
	        throw new RoleNotFoundException("Your not a Student " );
	    }
		
			 
		
		
		
		return studentRepo.save(student);
	}

	@Override
	public List<StudentProfile >showAllStudents() {
		List<StudentProfile> st=studentRepo.findAll();
		return st;
		
		
		
	}
//Faculty
	@Override
	public FacultyProfile registerFaculty(FacultyBinding fbinding) throws RoleNotFoundException {
		User user1 = userRepo.findById(fbinding.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
		Department  dept1=departmentRepo.findById(fbinding.getDepartmentId())
				.orElseThrow(() -> new RuntimeException("department id not found"));
		FacultyProfile fprofile=null;
	if(user1.getRole()==Role.FACULTY_MEMBER)
	{
		 fprofile=new FacultyProfile();
		
		fprofile.setPhoto(fbinding.getPhoto());
		fprofile.setOfficeHours(fbinding.getOfficeHours());
		fprofile.setUser(user1);
		fprofile.setDepartment(dept1);
	}
	else {
		throw new RoleNotFoundException("Your not a Facultymember" );
	}
	return facultyRepo.save(fprofile);
	}

	@Override
	public AdministratorProfile registerAdminiStrator(AdminiStratorBinding abinding) throws RoleNotFoundException {
		User user= userRepo.findById(abinding.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
		Department  dept=departmentRepo.findById(abinding.getDepartmentId())
				.orElseThrow(() -> new RuntimeException("department id not found"));
		AdministratorProfile aprofile=null;
		if(user.getRole()==Role.ADMINISTRATOR)
		{
         aprofile=new AdministratorProfile();
		aprofile.setUser(user);
		aprofile.setDepartment(dept);
		aprofile.setPhoto(abinding.getPhoto());
		
		}
		
		else {
			throw new RoleNotFoundException("Your not a AdminiStratorBinding" );
		}
		return AdminRepo.save(aprofile);
	
	}

	@Override
	public Course registerCourse(CourseBinding cbinding) {
		Department  dept=departmentRepo.findById(cbinding.getDepartmentId())
				.orElseThrow(() -> new RuntimeException("department id not found"));
		   FacultyProfile fprofile=facultyRepo.findById(cbinding.getFacultyId())
				   .orElseThrow(() -> new RuntimeException("faculty id not found"));
		   Course course=new Course();
		   course.setDepartment(dept);
		   course.setFaculty(fprofile);
		   course.setDescription(cbinding.getDescription());
		   course.setTitle(cbinding.getTitle());
		return courseRepo.save(course);
	}

	@Override
	public Enrollment registerEnrollment(EnrollmentBinding ebinding) {
		StudentProfile student=studentRepo.findById(ebinding.getStudentId())
				.orElseThrow(() -> new RuntimeException("Student id not found"));
		Course course=courseRepo.findById(ebinding.getCourseId())
				.orElseThrow(() -> new RuntimeException("Course id not found"));
		Enrollment enrollment=new Enrollment();
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		return enrollmentRepo.save(enrollment);
	}
	@Override
	 public User login(String username, String password)  {
	        return userRepo.findByUsernameAndPassword(username, password);
	        		     
	    }

	@Override
		public StudentProfile getStudentProfile(Long userId) {
			 return studentRepo.findById(userId)
		               .orElseThrow(() -> new RuntimeException("Student not found"));
		}
		
	
	
	

}

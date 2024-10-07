package com.nt.service;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import com.nt.bindings.AdminiStratorBinding;
import com.nt.bindings.CourseBinding;
import com.nt.bindings.DepartmentBinding;
import com.nt.bindings.EnrollmentBinding;
import com.nt.bindings.FacultyBinding;
import com.nt.bindings.StudentBinding;
import com.nt.bindings.UserBinding;
import com.nt.entity.AdministratorProfile;
import com.nt.entity.Course;
import com.nt.entity.Department;
import com.nt.entity.Enrollment;
import com.nt.entity.FacultyProfile;
import com.nt.entity.StudentProfile;
import com.nt.entity.User;

public interface ICollegeService {
	public User registerUser(UserBinding user);
	public StudentProfile registerStudent(StudentBinding sbinding) throws RoleNotFoundException;
	public FacultyProfile registerFaculty(FacultyBinding fbinding) throws RoleNotFoundException;
	public AdministratorProfile registerAdminiStrator(AdminiStratorBinding abinding) throws RoleNotFoundException;
	public Course registerCourse(CourseBinding cbinding);
	public Enrollment registerEnrollment(EnrollmentBinding ebinding);
	 public User login(String username, String password);
	 public StudentProfile getStudentProfile(Long userId);
	/*//User
	public User registerUserwithStudent(UserBinding ubinding,StudentBinding sbinding);
	//Department
	public  List<User> showAllUsers();
	
	public Department registeDepartment(DepartmentBinding dbindings);
	
	public FacultyProfile registerUserWithFaculty(UserBinding ubinding,FacultyBinding fbinding);*/
	
	public Department registerDepartment(DepartmentBinding dbindings);
	public List<StudentProfile>showAllStudents();
}

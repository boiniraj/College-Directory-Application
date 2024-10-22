# College-Directory-Application
## Introduction
I Develop a College Directory Application to facilitate seamless interaction between students, faculty members, and administrators within a single college. The application will allow users to manage and access personal and academic information efficiently.
## User Roles
- **Student**
- **Faculty Member**
- **Administrator**

## Requirements

### 1. Login Page
#### User Interface
- Simple form with fields for **Username**, **Password**, and a **role** selection dropdown (Student/Faculty Member/Administrator).
- Submit button to log in.

#### Functionality
- Validate user credentials against the PostgreSQL database.
- Redirect users to their respective dashboards based on their role.
- Implement error handling for incorrect credentials.

### 2. Student Interface
#### A. View Personal Profile
- Display personal information (name, photo, contact details).
- Display academic information (courses, grades, attendance).

#### B. Search for Other Students
- Search bar with filters for name, department, or year.
- List view displaying basic details of matching students.

#### C. Contact Faculty Advisors
- List view of assigned faculty advisors with contact options (email, phone).

### 3. Faculty Member Interface
#### A. Manage Class List
- List view of students in the faculty member's courses with columns for student names, photos, and contact information.

#### B. Update Profile
- Form to update office hours, contact email, and phone number.

### 4. Administrator Interface
#### A. Manage Student and Faculty Records
- Form to add, update, or remove student and faculty records.
- List view of records with options for CRUD operations.

## Technical Requirements

### Backend
- **Framework:** Java with Spring Boot
- **Database:** PostgreSQL
- **API Endpoints:**
  - User authentication and authorization
  - CRUD operations for profiles and records
  - Fetching student and faculty details
  - Dashboard data aggregation

### Database Schema
1. **User**
   - **Fields:** `id`, `username`, `password`, `role`, `name`, `email`, `phone`
   - **Explanation:** Stores basic login credentials and contact information for all users.

2. **StudentProfile**
   - **Fields:** `user_id`, `photo`, `department_id`, `year`
   - **Explanation:** Extends the User entity to include additional information specific to students.

3. **FacultyProfile**
   - **Fields:** `user_id`, `photo`, `department_id`, `office_hours`
   - **Explanation:** Extends the User entity to include additional information specific to faculty members.

4. **AdministratorProfile**
   - **Fields:** `user_id`, `photo`, `department_id`
   - **Explanation:** Extends the User entity to include additional information specific to administrators.

5. **Course**
   - **Fields:** `id`, `title`, `description`, `department_id`, `faculty_id`
   - **Explanation:** Stores information about the courses offered by the college.

6. **Enrollment**
   - **Fields:** `id`, `student_id`, `course_id`
   - **Explanation:** Represents the many-to-many relationship between students and courses.

7. **Department**
   - **Fields:** `id`, `name`, `description`
   - **Explanation:** Stores information about the various departments within the college.

## Relationships
- **User to Profiles:** One-to-One relationship with StudentProfile, FacultyProfile, or AdministratorProfile.
- **FacultyProfile to Course:** One-to-Many relationship where one faculty member can teach multiple courses.
- **Course to StudentProfile:** Many-to-Many relationship through Enrollment.
- **Department to Profiles/Course:** One-to-Many relationship where each department can have multiple users and courses.
  
## Installation Instructions
- Clone the repository.
- Set up the MySQL database.
- Configure application properties.
- Run the application.
  
## Future Improvements
- Implement a frontend interface using React.
- Enhance security with JWT tokens for authentication.
 ![my pic]("https://github.com/boiniraj/College-Directory-Application/blob/main/Screenshot%202024-10-22%20213017.png")

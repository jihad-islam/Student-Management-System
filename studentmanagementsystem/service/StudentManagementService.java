package studentmanagementsystem.service;

import studentmanagementsystem.dao.CourseDAO;
import studentmanagementsystem.dao.EnrollmentDAO;
import studentmanagementsystem.dao.StudentDAO;
import studentmanagementsystem.model.Course;
import studentmanagementsystem.model.Enrollment;
import studentmanagementsystem.model.Student;

import java.util.List;

/**
 * Service class for the Student Management System.
 */
public class StudentManagementService {
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private EnrollmentDAO enrollmentDAO;
    
    public StudentManagementService() {
        this.studentDAO = new StudentDAO();
        this.courseDAO = new CourseDAO();
        this.enrollmentDAO = new EnrollmentDAO();
        
        // Add sample data
        initSampleData();
    }
    
    private void initSampleData() {
        // Add sample students with specified IDs
        Student s1 = new Student("5796", "Jihad", 20, "jihad@example.com");
        Student s2 = new Student("5896", "Sadman", 22, "sadman@example.com");
        studentDAO.addStudent(s1);
        studentDAO.addStudent(s2);
        
        // Add sample courses
        Course c1 = new Course(null, "Java Programming", "Prof. Johnson");
        Course c2 = new Course(null, "Database Systems", "Dr. Wilson");
        courseDAO.addCourse(c1);
        courseDAO.addCourse(c2);
        
        // Add sample enrollments
        enrollmentDAO.addEnrollment(new Enrollment(s1.getId(), c1.getId()));
        enrollmentDAO.addEnrollment(new Enrollment(s2.getId(), c1.getId()));
        enrollmentDAO.addEnrollment(new Enrollment(s1.getId(), c2.getId()));
    }
    
    // Student methods
    public Student addStudent(String name, int age, String contact) {
        Student student = new Student(null, name, age, contact);
        return studentDAO.addStudent(student);
    }
    
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
    
    public Student getStudentById(String id) {
        return studentDAO.getStudentById(id);
    }
    
    // Course methods
    public Course addCourse(String name, String instructor) {
        Course course = new Course(null, name, instructor);
        return courseDAO.addCourse(course);
    }
    
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
    
    public Course getCourseById(String id) {
        return courseDAO.getCourseById(id);
    }
    
    // Simplified Enrollment methods
    public void enrollStudent(String studentId, String courseId) {
        // Check if already enrolled
        List<Enrollment> studentEnrollments = enrollmentDAO.getEnrollmentsByStudentId(studentId);
        for (Enrollment e : studentEnrollments) {
            if (e.getCourseId().equals(courseId)) {
                return; // Already enrolled, do nothing
            }
        }
        
        // Create new enrollment
        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollmentDAO.addEnrollment(enrollment);
    }
    
    // Get all courses a student is enrolled in
    public List<Enrollment> getStudentEnrollments(String studentId) {
        return enrollmentDAO.getEnrollmentsByStudentId(studentId);
    }
    
    // Get all students enrolled in a course
    public List<Enrollment> getCourseEnrollments(String courseId) {
        return enrollmentDAO.getEnrollmentsByCourseId(courseId);
    }
    
    // Simple method to assign a grade
    public void assignGrade(String studentId, String courseId, String grade) {
        List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByStudentId(studentId);
        for (Enrollment e : enrollments) {
            if (e.getCourseId().equals(courseId)) {
                e.setGrade(grade);
                break;
            }
        }
    }
}
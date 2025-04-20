package studentmanagementsystem.ui;

import studentmanagementsystem.model.Course;
import studentmanagementsystem.model.Enrollment;
import studentmanagementsystem.model.Student;
import studentmanagementsystem.service.StudentManagementService;

import java.util.List;
import java.util.Scanner;

/**
 * Main UI class for the Student Management System.
 */
public class StudentManagementSystem {
    private static StudentManagementService service = new StudentManagementService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean running = true;
        
        System.out.println("===== Student Management System =====");
        
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    enrollmentMenu();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using the Student Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void studentMenu() {
        while (true) {
            System.out.println("\nStudent Management:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student Details");
            System.out.println("0. Back to Main Menu");
            
            System.out.print("Enter your choice: ");
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewStudentDetails();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    private static void courseMenu() {
        while (true) {
            System.out.println("\nCourse Management:");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. View Course Details");
            System.out.println("0. Back to Main Menu");
            
            System.out.print("Enter your choice: ");
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewAllCourses();
                    break;
                case 3:
                    viewCourseDetails();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    // Simplified enrollment menu
    private static void enrollmentMenu() {
        while (true) {
            System.out.println("\nEnrollment Management:");
            System.out.println("1. Enroll a Student in a Course");
            System.out.println("2. View Student's Courses");
            System.out.println("3. Assign a Grade");
            System.out.println("0. Back to Main Menu");
            
            System.out.print("Enter your choice: ");
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    enrollStudent();
                    break;
                case 2:
                    viewStudentCourses();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    // Student methods
    private static void addStudent() {
        System.out.println("\nAdd Student:");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age = getIntInput();
        
        System.out.print("Enter student contact: ");
        String contact = scanner.nextLine();
        
        Student student = service.addStudent(name, age, contact);
        System.out.println("Student added successfully with ID: " + student.getId());
    }
    
    private static void viewAllStudents() {
        System.out.println("\nAll Students:");
        List<Student> students = service.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student.getId() + ": " + student.getName());
            }
        }
    }
    
    private static void viewStudentDetails() {
        System.out.print("\nEnter student ID: ");
        String id = scanner.nextLine();
        
        Student student = service.getStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Student Details:");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Contact: " + student.getContact());
        }
    }
    
    // Course methods
    private static void addCourse() {
        System.out.println("\nAdd Course:");
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();
        
        Course course = service.addCourse(name, instructor);
        System.out.println("Course added successfully with ID: " + course.getId());
    }
    
    private static void viewAllCourses() {
        System.out.println("\nAll Courses:");
        List<Course> courses = service.getAllCourses();
        
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (Course course : courses) {
                System.out.println(course.getId() + ": " + course.getName() + " (Instructor: " + course.getInstructor() + ")");
            }
        }
    }
    
    private static void viewCourseDetails() {
        System.out.print("\nEnter course ID: ");
        String id = scanner.nextLine();
        
        Course course = service.getCourseById(id);
        if (course == null) {
            System.out.println("Course not found!");
        } else {
            System.out.println("Course Details:");
            System.out.println("ID: " + course.getId());
            System.out.println("Name: " + course.getName());
            System.out.println("Instructor: " + course.getInstructor());
        }
    }
    
    // Simplified enrollment methods
    private static void enrollStudent() {
        // Show available students and courses
        viewAllStudents();
        System.out.print("\nEnter student ID to enroll: ");
        String studentId = scanner.nextLine();
        
        Student student = service.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        viewAllCourses();
        System.out.print("\nEnter course ID: ");
        String courseId = scanner.nextLine();
        
        Course course = service.getCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        
        service.enrollStudent(studentId, courseId);
        System.out.println(student.getName() + " has been enrolled in " + course.getName());
    }
    
    private static void viewStudentCourses() {
        viewAllStudents();
        System.out.print("\nEnter student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = service.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.println("\nCourses for " + student.getName() + ":");
        List<Enrollment> enrollments = service.getStudentEnrollments(studentId);
        
        if (enrollments.isEmpty()) {
            System.out.println("Not enrolled in any courses.");
            return;
        }
        
        for (Enrollment enrollment : enrollments) {
            Course course = service.getCourseById(enrollment.getCourseId());
            if (course != null) {
                System.out.println("- " + course.getName() + " (Grade: " + enrollment.getGrade() + ")");
            }
        }
    }
    
    private static void assignGrade() {
        viewAllStudents();
        System.out.print("\nEnter student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = service.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        // Show student's courses
        System.out.println("\nCourses for " + student.getName() + ":");
        List<Enrollment> enrollments = service.getStudentEnrollments(studentId);
        
        if (enrollments.isEmpty()) {
            System.out.println("Not enrolled in any courses.");
            return;
        }
        
        for (Enrollment enrollment : enrollments) {
            Course course = service.getCourseById(enrollment.getCourseId());
            if (course != null) {
                System.out.println(course.getId() + ": " + course.getName() + " (Current grade: " + enrollment.getGrade() + ")");
            }
        }
        
        System.out.print("\nEnter course ID: ");
        String courseId = scanner.nextLine();
        
        System.out.print("Enter grade (A/B/C/D/F): ");
        String grade = scanner.nextLine();
        
        service.assignGrade(studentId, courseId, grade);
        System.out.println("Grade assigned successfully!");
    }
    
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
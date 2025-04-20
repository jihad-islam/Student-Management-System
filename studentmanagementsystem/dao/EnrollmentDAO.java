package studentmanagementsystem.dao;

import studentmanagementsystem.model.Enrollment;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Enrollment entities.
 */
public class EnrollmentDAO {
    private List<Enrollment> enrollments = new ArrayList<>();
    
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
    
    public List<Enrollment> getEnrollmentsByStudentId(String studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                result.add(enrollment);
            }
        }
        return result;
    }
    
    public List<Enrollment> getEnrollmentsByCourseId(String courseId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId().equals(courseId)) {
                result.add(enrollment);
            }
        }
        return result;
    }
    
    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
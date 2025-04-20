package studentmanagementsystem.model;

/**
 * Represents an enrollment of a student in a course.
 */
public class Enrollment {
    private String studentId;
    private String courseId;
    private String grade;
    
    public Enrollment(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = "Not Graded";
    }
    
    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return "Enrollment{studentId='" + studentId + "', courseId='" + courseId + "', grade='" + grade + "'}";
    }
}
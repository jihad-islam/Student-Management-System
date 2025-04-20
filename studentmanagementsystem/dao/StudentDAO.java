package studentmanagementsystem.dao;

import studentmanagementsystem.model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Access Object for Student entities.
 */
public class StudentDAO {
    private Map<String, Student> students = new HashMap<>();
    private int idCounter = 1000;
    
    public String generateId() {
        return "S" + (++idCounter);
    }
    
    public Student addStudent(Student student) {
        if (student.getId() == null || student.getId().isEmpty()) {
            student.setId(generateId());
        }
        students.put(student.getId(), student);
        return student;
    }
    
    public Student getStudentById(String id) {
        return students.get(id);
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    
    public boolean updateStudent(Student student) {
        if (student.getId() != null && students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return true;
        }
        return false;
    }
    
    public boolean deleteStudent(String id) {
        if (students.containsKey(id)) {
            students.remove(id);
            return true;
        }
        return false;
    }
}
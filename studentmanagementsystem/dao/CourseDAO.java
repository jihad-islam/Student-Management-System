package studentmanagementsystem.dao;

import studentmanagementsystem.model.Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Access Object for Course entities.
 */
public class CourseDAO {
    private Map<String, Course> courses = new HashMap<>();
    private int idCounter = 100;
    
    public String generateId() {
        return "C" + (++idCounter);
    }
    
    public Course addCourse(Course course) {
        if (course.getId() == null || course.getId().isEmpty()) {
            course.setId(generateId());
        }
        courses.put(course.getId(), course);
        return course;
    }
    
    public Course getCourseById(String id) {
        return courses.get(id);
    }
    
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }
    
    public boolean updateCourse(Course course) {
        if (course.getId() != null && courses.containsKey(course.getId())) {
            courses.put(course.getId(), course);
            return true;
        }
        return false;
    }
    
    public boolean deleteCourse(String id) {
        if (courses.containsKey(id)) {
            courses.remove(id);
            return true;
        }
        return false;
    }
}
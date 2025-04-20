package studentmanagementsystem.model;

/**
 * Represents a course in the Student Management System.
 */
public class Course {
    private String id;
    private String name;
    private String instructor;
    
    public Course(String id, String name, String instructor) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    
    @Override
    public String toString() {
        return "Course{id='" + id + "', name='" + name + "', instructor='" + instructor + "'}";
    }
}
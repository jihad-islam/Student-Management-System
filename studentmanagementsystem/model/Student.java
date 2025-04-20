package studentmanagementsystem.model;

/**
 * Represents a student in the Student Management System.
 */
public class Student {
    private String id;
    private String name;
    private int age;
    private String contact;
    
    public Student(String id, String name, int age, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age=" + age + ", contact='" + contact + "'}";
    }
}
import java.util.*;

class Student {
    int id; String name; float gpa;
    List<String> courses = new ArrayList<>();
    public Student(int k, String n, float g) {
        id = k; name = n; gpa = g;
    }
    public void addCourse(String code) { courses.add(code); }
    public String toString() { return name; }
    public int hashCode() { return id; }
    public boolean equals(Object x) {
        if (!(x instanceof Student)) return false;
        Student s = (Student)x; 
        return (s.id == id);
    }
}

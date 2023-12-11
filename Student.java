import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private List<String> courses;

    
    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    
    public Student(String studentId, String name, int age, List<String> courses) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>(courses); 
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void display() {
        System.out.println("Student ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Courses: " + courses);
    }
}

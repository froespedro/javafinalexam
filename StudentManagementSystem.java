import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StudentManagementSystem {

    public static void main(String[] args) {
        
        ArrayList<Student> studentRoster = new ArrayList<>();

        
        studentRoster.add(new Student("S001", "Pedro", 28, List.of("Anatomy", "Biochemistry")));
        studentRoster.add(new Student("S002", "Camila", 25, List.of("Pharmacology", "Neuroscience")));
        studentRoster.add(new Student("S003", "Luana", 32, List.of("Physiology", "Genetics")));
        studentRoster.add(new Student("S004", "Gustavo", 47, List.of("Public Health", "Epidemiology")));

       
        studentRoster.forEach(Student::display);

        
        displayStudentsEnrolledInCourse(studentRoster, "Anatomy");

        
        setStudentAge(studentRoster, "S001", 24);

       
        displayMeanStudentAge(studentRoster);
    }

    private static void displayStudentsEnrolledInCourse(ArrayList<Student> studentRoster, String course) {
        studentRoster.stream()
                .filter(student -> student.getCourses().contains(course))
                .forEach(Student::display);
    }

    private static void setStudentAge(ArrayList<Student> studentRoster, String studentId, int age) {
        studentRoster.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .ifPresent(student -> student.setAge(age));
    }

    private static void displayMeanStudentAge(ArrayList<Student> studentRoster) {
        OptionalDouble average = studentRoster.stream()
                .mapToInt(Student::getAge)
                .average();
        
        System.out.printf("Mean Student Age: %.2f\n", average.orElse(0));
    }
}

class Student {
    private String id;
    private String name;
    private int age;
    private List<String> enrolledCourses;

    public Student(String id, String name, int age, List<String> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.enrolledCourses = new ArrayList<>(courses);
    }

    public void addCourse(String course) {
        enrolledCourses.add(course);
    }

    public String getStudentId() {
        return id;
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
        return enrolledCourses;
    }

    public void display() {
        System.out.printf("Student ID: %s, Name: %s, Age: %d, Courses: %s\n", id, name, age, String.join(", ", enrolledCourses));
    }
}

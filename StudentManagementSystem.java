import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {

    public static void main(String[] args) {
        ArrayList<Student> studentRoster = new ArrayList<>();

        
        studentRoster.add(new Student("S001", "Pedro", 28, List.of("Anatomy", "Biochemistry")));
        studentRoster.add(new Student("S002", "Camila", 25, List.of("Pharmacology", "Neuroscience")));
        studentRoster.add(new Student("S003", "Luana", 32, List.of("Physiology", "Genetics")));
        studentRoster.add(new Student("S004", "Gustavo", 47, List.of("Public Health", "Epidemiology")));

        
        System.out.println("All Students:");
        studentRoster.forEach(Student::display);

        
        System.out.println("\nStudents Enrolled in Anatomy:");
        displayStudentsEnrolledInCourse(studentRoster, "Anatomy");

        
        System.out.println("\nUpdating age of Pedro (S001) to 24:");
        setStudentAge(studentRoster, "S001", 24);
        studentRoster.forEach(Student::display);

        
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
        double average = studentRoster.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        
        System.out.printf("Mean Student Age: %.2f\n", average);
    }
}

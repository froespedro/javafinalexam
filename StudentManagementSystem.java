import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManagementSystem {

    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<>();
        

        Student student1 = new Student("S001", "Pedro", 28);
        student1.addCourse("Mathematics");
        student1.addCourse("Computer Science");
        students.add(student1);

        Student student2 = new Student("S002", "Camila", 25);
        student2.addCourse("Physics");
        student2.addCourse("Computer Science");
        students.add(student2);

        Student student3 = new Student("S003", "Luana", 19);
        student3.addCourse("Literature");
        student3.addCourse("Biology");
        students.add(student3);

        Student student4 = new Student("S004", "Gustavo", 22);
        student4.addCourse("Economics");
        student4.addCourse("History");
        students.add(student4);

        
        students.forEach(Student::displayStudentDetails);

        
        findStudentsInCourse(students, "Computer Science");

        
        updateStudentAge(students, "S001", 24);

        
        displayAverageAge(students);
    }

    private static void findStudentsInCourse(List<Student> students, String course) {
        List<Student> enrolledStudents = students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());
        System.out.println("Students enrolled in " + course + ":");
        enrolledStudents.forEach(Student::displayStudentDetails);
    }

    private static void updateStudentAge(List<Student> students, String studentId, int newAge) {
        students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .ifPresent(s -> s.setAge(newAge));
    }

    private static void displayAverageAge(List<Student> students) {
        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Average Age: " + averageAge);
    }
}

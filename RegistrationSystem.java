package Project;
import java.util.ArrayList;
public class RegistrationSystem {

    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (findStudent(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }

        students.add(student);
        System.out.println("Student added successfully.");
        return true;
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            System.out.println("--------------------");
            student.displayInfo();
        }
    }

    public boolean updateMarks(int id, double newMarks) {
        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        try {
            student.setMarks(newMarks);
            System.out.println("Marks updated successfully.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
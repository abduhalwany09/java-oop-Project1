package Project;


public abstract class Student implements Passable {

    private String name;
    private int id;
    private double marks;

    public Student(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100."
            );
        }
        this.marks = marks;
    }

    public abstract double getPassingGrade();

    @Override
    public boolean isPassed() {
        return marks >= getPassingGrade();
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Passing Grade: " + getPassingGrade());
        System.out.println("Result: " + (isPassed() ? "Pass" : "Fail"));
    }
}

package Project;


public class GradStudent extends Student {

    public GradStudent(String name, int id, double marks) {
        super(name, id, marks);
    }

    
    public double getPassingGrade() {
        return 80.0;
    }
}
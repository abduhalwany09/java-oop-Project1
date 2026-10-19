package Project;


public class UndergradStudent extends Student {

    public UndergradStudent(String name, int id, double marks) {
        super(name, id, marks);
    }

    @Override
    public double getPassingGrade() {
        return 60.0;
    }
}

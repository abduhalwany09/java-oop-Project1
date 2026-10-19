package Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        RegistrationSystem system = new RegistrationSystem();

        int choice;

        do {
            System.out.println("\n===== Student Registration System =====");
            System.out.println("1. Add Undergraduate Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
                choice = 0;
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                case 2:
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();

                    System.out.print("Enter student ID: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Invalid student ID.");
                        input.nextLine();
                        break;
                    }
                    int id = input.nextInt();

                    System.out.print("Enter marks (0-100): ");
                    if (!input.hasNextDouble()) {
                        System.out.println("Invalid marks.");
                        input.nextLine();
                        break;
                    }
                    double marks = input.nextDouble();
                    input.nextLine();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    Student student;

                    if (choice == 1) {
                        student = new UndergradStudent(name, id, marks);
                    } else {
                        student = new GradStudent(name, id, marks);
                    }

                    system.addStudent(student);
                    break;

                case 3:
                    system.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Invalid student ID.");
                        input.nextLine();
                        break;
                    }
                    int updateId = input.nextInt();

                    System.out.print("Enter new marks (0-100): ");
                    if (!input.hasNextDouble()) {
                        System.out.println("Invalid marks.");
                        input.nextLine();
                        break;
                    }
                    double newMarks = input.nextDouble();
                    input.nextLine();

                    system.updateMarks(updateId, newMarks);
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}
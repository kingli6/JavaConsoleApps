import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final Map<Integer, Student> studentMap = new HashMap<>();
    private static int nextRollNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        Student student = new Student(nextRollNumber, name);
        studentMap.put(nextRollNumber, student);

        System.out.println("Student added successfully. Roll Number: " + nextRollNumber);
        nextRollNumber++;
    }

    private static void viewStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nStudent List:");
            for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
                System.out.println("Roll Number: " + entry.getKey() + ", Name: " + entry.getValue().getName());
            }
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter the roll number of the student to update: ");
        int rollNumber = scanner.nextInt();

        if (studentMap.containsKey(rollNumber)) {
            System.out.print("Enter the new name for the student: ");
            String newName = scanner.next();

            Student student = studentMap.get(rollNumber);
            student.setName(newName);

            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found with Roll Number: " + rollNumber);
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter the roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();

        if (studentMap.containsKey(rollNumber)) {
            studentMap.remove(rollNumber);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with Roll Number: " + rollNumber);
        }
    }
}

class Student {
    private int rollNumber;
    private String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

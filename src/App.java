import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nHello, User!\n");
        ToDoList toDoList = new ToDoList();

        // Load tasks from file
        loadTasksFromFile(toDoList);

        // Use try-with-resources for Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add Task");
                System.out.println("2. Mark Task as Completed");
                System.out.println("3. Remove Task");
                System.out.println("4. Display Tasks");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        toDoList.addTask(description);
                        break;
                    case 2:
                        System.out.print("Enter task index to mark as completed: ");
                        int indexMark = scanner.nextInt();
                        toDoList.markTaskAsCompleted(indexMark - 1);
                        break;
                    case 3:
                        System.out.print("Enter task index to remove: ");
                        int indexRemove = scanner.nextInt();
                        toDoList.removeTask(indexRemove - 1);
                        break;
                    case 4:
                        System.out.println("Tasks:");
                        toDoList.displayTasks();
                        break;
                    case 0:
                        System.out.println("Exiting application. Goodbye!");

                        // Save tasks to file before exiting
                        saveTasksToFile(toDoList);

                        System.exit(0); // <- exit
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } // The Scanner will be automatically closed when exiting the try block

    }

    private static void loadTasksFromFile(ToDoList toDoList) {
        try (Scanner fileScanner = new Scanner(new File("tasks.txt"))) {
            while (fileScanner.hasNextLine()) {
                String description = fileScanner.nextLine();
                toDoList.addTask(description);
            }
        } catch (IOException e) {
            // Handle file not found or other IO exceptions
            System.out.println("Could not load tasks from file. Starting with an empty list.");
        }
    }

    private static void saveTasksToFile(ToDoList toDoList) {
        try (FileWriter fileWriter = new FileWriter("tasks.txt")) {
            for (Task task : toDoList.getTasks()) {
                fileWriter.write(task.getDescription() + "\n");
            }
        } catch (IOException e) {
            // Handle IO exception while writing to file
            System.out.println("Could not save tasks to file.");
        }
    }
}

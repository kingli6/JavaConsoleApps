import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> tasks; // This class(ToDoList) has an ArrayList List<Task>

    public ToDoList() {
        this.tasks = new ArrayList<>(); // Constructor
    }

    public void addTask(String description) {
        Task task = new Task(description); // Method that uses class-Task boiler plate to store String into the
                                           // list-array HERE. //using the constructor!
        tasks.add(task);
    }

    public void markTaskAsCompleted(int index) { // user sends index
        if (index >= 0 && index < tasks.size()) { // if valid input
            Task task = tasks.get(index); // we are plucking the item from the array-list
            task.setCompleted(true);
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}

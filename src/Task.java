public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Getters and setters (optional)
    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    @Override
    public String toString() {
        return "[" + (isCompleted ? "X" : " ") + "] " + description;
    }
}

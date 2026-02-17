package Monad.tasks;

/**
 * Represents a task
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType type;

    /**
     * Creates a new task with the given description and task type.
     *
     * @param description The description of the task
     * @param type The type of task
     */
    public Task(String description, TaskType type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }

    /**
     * Gets the status of the task
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Returns the description of the task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Converts the task into a string format
     */
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return "[" + type.getSymbol() + "]" + status + " " + description;
    }

    /**
     * Converts the task into a format for file storage
     */
    public String toFileString() {
        return type.getSymbol() + " | "
                + (isDone ? "1" : "0") + " | "
                + description;
    }

}
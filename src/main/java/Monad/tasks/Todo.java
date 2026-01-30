package Monad.tasks;

/**
 * Represents a todo entry
 */
public class Todo extends Task {

    /**
     * Creates a new todo entry with the given description.
     *
     * @param description The description of the task
     */
    public Todo(String description) {
        super(description, TaskType.TODO);
    }

    /**
     * Converts the todo entry into a string format
     */
    @Override
    public String toString(){
        return super.toString();
    }
}

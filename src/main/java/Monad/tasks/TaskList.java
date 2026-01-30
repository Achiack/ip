package Monad.tasks;

import java.util.ArrayList;

/**
 * Represents a List of Tasks
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates a new empty list of Tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a list of Tasks.
     *
     * @param tasks The tasks to be put in the list
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a Task to the TaskList.
     *
     * @param t The task to be added
     */
    public void add(Task t) {
        this.tasks.add(t);
    }

    /**
     * Removes a Task from the TaskList.
     *
     * @param index The index of task to be removed
     */
    public void remove(int index) {
        this.tasks.remove(index);
    }

    /**
     * Returns a Task from the TaskList.
     *
     * @param index The index of task to retrieve
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the size of the TaskList
     */
    public int size() {
        return tasks.size();
    }
    /**
     * Returns the ArrayList
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

package Monad.ui;

import Monad.tasks.Task;
import Monad.tasks.TaskList;

import java.util.Scanner;

/**
 * Represents the UI handler
 */
public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Displays the welcome message on the UI
     */
    public void showWelcome() {
        System.out.println("____________________________________________");
        System.out.println("Hello! I'm Monad");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________");
    }

    /**
     * Displays the goodbye message on the UI
     */
    public void showGoodbye(){
        System.out.println("____________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________");
    }

    /**
     * Displays a list of all tasks on the UI
     *
     * @param taskList The list of tasks to display
     */
    public void showList(TaskList taskList){
        System.out.println("____________________________________________");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }
        System.out.println("____________________________________________");
    }

    /**
     * Reads the next command that the user inputs
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays an error message on the UI
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays the file handling error message on the UI
     */
    public void showLoadingError() {
        System.out.println("Error loading file.");
    }

    /**
     * Displays a success message after adding a task
     *
     * @param task The task that was added
     * @param size The size of the task list
     */
    public void showAdd(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Displays a success message after deleting a task
     *
     * @param task The task that was deleted
     * @param size The size of the task list
     */
    public void showDelete(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Displays a success message after marking a task as completed
     *
     * @param task The task that was marked as completed
     */
    public void showMark(Task task){
        System.out.println("____________________________________________");
        System.out.println("Nice! I've marked this task as done:\n");
        System.out.println(task.toString());
        System.out.println("____________________________________________");
    }

    /**
     * Displays a success message after marking a task as not completed
     *
     * @param task The task that was marked as not completed
     */
    public void showUnmark(Task task){
        System.out.println("____________________________________________");
        System.out.println("OK, I've marked this task as not done yet:\n");
        System.out.println(task.toString());
        System.out.println("____________________________________________");
    }

    public void showFindResults(TaskList tasks, String keyword) {
        showLine();
        System.out.println("Here are the matching tasks in your list:");

        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(keyword)) {
                count++;
                System.out.println(count + "." + task);
            }
        }

        if (count == 0) {
            System.out.println("No matching tasks found.");
        }

        showLine();
    }

}

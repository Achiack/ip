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
     * Prints multiple lines of text on the UI
     */
    private void printBox(String... lines) {
        System.out.println("____________________________________________");
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("____________________________________________");
    }

    /**
     * Displays the welcome message on the UI
     */
    public void showWelcome() {
        printBox(
                "Hello! I'm Monad",
                "What can I do for you?"
        );
    }

    /**
     * Displays the goodbye message on the UI
     */
    public void showGoodbye(){
        printBox("Bye. Hope to see you again soon!");
    }

    /**
     * Displays a list of all tasks on the UI
     *
     * @param taskList The list of tasks to display
     */
    public void showList(TaskList taskList){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }
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
        printBox(
                "Got it. I've added this task:",
                " " + task,
                "Now you have " + size + " tasks in the list."
        );
    }

    /**
     * Displays a success message after deleting a task
     *
     * @param task The task that was deleted
     * @param size The size of the task list
     */
    public void showDelete(Task task, int size) {
        printBox(
                "Noted. I've removed this task:",
                " " + task,
                "Now you have " + size + " tasks in the list."
        );
    }

    /**
     * Displays a success message after marking a task as completed
     *
     * @param task The task that was marked as completed
     */
    public void showMark(Task task){
        printBox(
                "Nice! I've marked this task as done:",
                task.toString()
        );
    }

    /**
     * Displays a success message after marking a task as not completed
     *
     * @param task The task that was marked as not completed
     */
    public void showUnmark(Task task){
        printBox(
                "OK, I've marked this task as not done yet:",
                task.toString()
        );
    }

    public void showFindResults(TaskList tasks, String keyword) {
        System.out.println("____________________________________________");
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
        System.out.println("____________________________________________");
    }

}

import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("____________________________________________");
        System.out.println("Hello! I'm Monad");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________");
    }

    public void showGoodbye(){
        System.out.println("____________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________");
    }

    public void showList(TaskList taskList){
        System.out.println("____________________________________________");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }
        System.out.println("____________________________________________");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("____________________________________________");
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("Error loading file.");
    }

    public void showAdd(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showDelete(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showMark(Task task){
        System.out.println("____________________________________________");
        System.out.println("Nice! I've marked this task as done:\n");
        System.out.println(task.toString());
        System.out.println("____________________________________________");
    }

    public void showUnmark(Task task){
        System.out.println("____________________________________________");
        System.out.println("OK, I've marked this task as not done yet:\n");
        System.out.println(task.toString());
        System.out.println("____________________________________________");
    }

}

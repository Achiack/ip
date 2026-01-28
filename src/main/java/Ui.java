import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("____________________________________________");
        System.out.println("Hello! I'm Monad");
        System.out.println("What can I do for you?");
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

    public void showAdded(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showDeleted(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}

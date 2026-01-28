import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Monad {
    public static void main(String[] args) {
        String ChatbotName = "Monad";
        Scanner sc = new Scanner(System.in);
        Storage file = new Storage("./data/monad.txt");
        ArrayList<Task> tasks;
        try {
            tasks = file.load();
        }
        catch (IOException e) {
            tasks = new ArrayList<>();
            System.out.println("Warning: Could not load data.");
        }

        System.out.println("___________________________");
        System.out.println("Hello! I'm " + ChatbotName);
        System.out.println("What can I do for you?");
        System.out.println("___________________________");

        while (true) {
            try{
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("___________________________");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("___________________________");
                    break;
                }

                else if (input.startsWith("todo")) {
                    if (input.length() < 5) {
                        throw new MonadException("OOPS!!! The description of a todo cannot be empty.");
                    }

                    String desc = input.substring(5).trim();
                    if (desc.isEmpty()) {
                        throw new MonadException("OOPS!!! The description of a todo cannot be empty.");
                    }

                    Task t = new Todo(desc);
                    tasks.add(t);
                    try {
                        file.save(tasks);
                    }
                    catch (IOException e) {
                        System.out.println("Error saving tasks to file.");
                    }
                    System.out.println("___________________________");
                    System.out.println("Got it. I've added this task:\n");
                    System.out.println(t.toString());
                    System.out.println("\nNow you have " + tasks.size() + " tasks in the list.");
                    System.out.println("___________________________");
                }

                else if (input.startsWith("deadline")) {
                    if (input.length() < 9) {
                        throw new MonadException("OOPS!!! The description or date of a deadline cannot be empty.");
                    }

                    String[] parts = input.substring(9).split(" /by ", 2);

                    if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                        throw new MonadException("OOPS!!! The description or date of a deadline cannot be empty.");
                    }

                    Task t = new Deadline(parts[0], parts[1]);
                    tasks.add(t);
                    try {
                        file.save(tasks);
                    }
                    catch (IOException e) {
                        System.out.println("Error saving tasks to file.");
                    }
                    System.out.println("___________________________");
                    System.out.println("Got it. I've added this task:\n");
                    System.out.println(t.toString());
                    System.out.println("\nNow you have " + tasks.size() + " tasks in the list.");
                    System.out.println("___________________________");
                }

                else if (input.startsWith("event")) {
                    if (input.length() < 6) {
                        throw new MonadException("OOPS!!! The description or time of an event cannot be empty.");
                    }
                    String[] parts = input.substring(6).split(" /from | /to ", 3);

                    if (parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
                        throw new MonadException("OOPS!!! The description or time of an event cannot be empty.");
                    }

                    Task t = new Event(parts[0], parts[1], parts[2]);
                    tasks.add(t);
                    try {
                        file.save(tasks);
                    }
                    catch (IOException e) {
                        System.out.println("Error saving tasks to file.");
                    }
                    System.out.println("___________________________");
                    System.out.println("Got it. I've added this task:\n");
                    System.out.println(t.toString());
                    System.out.println("\nNow you have " + tasks.size() + " tasks in the list.");
                    System.out.println("___________________________");
                }

                else if (input.equalsIgnoreCase("list")) {
                    System.out.println("___________________________");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i));
                    }
                    System.out.println("___________________________");
                }

                else if (input.startsWith("mark")) {
                    int index = Integer.parseInt(input.substring(5)) - 1;
                    tasks.get(index).markAsDone();
                    System.out.println("___________________________");
                    System.out.println("Nice! I've marked this task as done:\n");
                    System.out.println(tasks.get(index).toString());
                    System.out.println("___________________________");
                }

                else if (input.startsWith("unmark")) {
                    int index = Integer.parseInt(input.substring(7)) - 1;
                    tasks.get(index).unmark();
                    System.out.println("___________________________");
                    System.out.println("OK, I've marked this task as not done yet:\n");
                    System.out.println(tasks.get(index).toString());
                    System.out.println("___________________________");
                }

                else if (input.startsWith("delete")) {
                    if (input.length() < 7) {
                        throw new MonadException("OOPS!!! You need to specify the index of the task to delete.");
                    }

                    String[] parts = input.split(" ");

                    if (parts.length != 2) {
                        throw new MonadException("OOPS!!! Please provide exactly one task number.");
                    }

                    int index;

                    try {
                        index = Integer.parseInt(parts[1]) - 1; // convert to 0-based index
                    }

                    catch (NumberFormatException e) {
                        throw new MonadException("OOPS!!! Task number must be a number.");
                    }

                    if (index < 0 || index >= tasks.size()) {
                        throw new MonadException("OOPS!!! That task number is out of range.");
                    }

                    Task removedTask = tasks.remove(index);

                    System.out.println("____________________________________________________________");
                    System.out.println(" Noted. I've removed this task:");
                    System.out.println("   " + removedTask);
                    System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }

                else {
                    throw new MonadException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }

            catch (MonadException | NumberFormatException e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
            }
        }

        sc.close();
    }
}

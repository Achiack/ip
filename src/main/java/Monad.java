import java.util.Scanner;
import java.util.ArrayList;

public class Monad {
    public static void main(String[] args) {
        String ChatbotName = "Monad";
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("___________________________");
        System.out.println("Hello! I'm " + ChatbotName);
        System.out.println("What can I do for you?");
        System.out.println("___________________________");

        while (true) {
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("bye")) {
                System.out.println("___________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("___________________________");
                break;
            }

            else if(input.equalsIgnoreCase("list")) {
                System.out.println("___________________________");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + "." + tasks.get(i));
                }
                System.out.println("___________________________");
            }

            else if(input.startsWith("mark")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                tasks.get(index).markAsDone();
                System.out.println("___________________________");
                System.out.println("Nice! I've marked this task as done:\n");
                System.out.println(tasks.get(index).toString());
                System.out.println("___________________________");
            }

            else if(input.startsWith("unmark")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                tasks.get(index).unmark();
                System.out.println("___________________________");
                System.out.println("OK, I've marked this task as not done yet:\n");
                System.out.println(tasks.get(index).toString());
                System.out.println("___________________________");
            }

            else {
                Task t = new Task(input);
                tasks.add(t);
                System.out.println("___________________________");
                System.out.println("added: " + input);
                System.out.println("___________________________");
            }
        }

        sc.close();
    }
}

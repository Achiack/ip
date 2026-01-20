import java.util.Scanner;

public class Monad {
    public static void main(String[] args) {
        String ChatbotName = "Monad";
        Scanner sc = new Scanner(System.in);


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
            else {
                System.out.println("___________________________");
                System.out.println(input);
                System.out.println("___________________________");
            }
        }

        sc.close();
    }
}

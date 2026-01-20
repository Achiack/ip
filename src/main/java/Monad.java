import java.util.Scanner;

public class Monad {
    public static void main(String[] args) {
        String ChatbotName = "Monad";
        Scanner sc = new Scanner(System.in);
        String[] mem = new String[100];
        int memCount = 0;

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

            if(input.equalsIgnoreCase("list")) {
                System.out.println("___________________________");
                for (int i = 0; i < memCount; i++) {
                    System.out.println((i + 1) + ". " + mem[i]);
                }
                System.out.println("___________________________");
            }

            else {
                mem[memCount] = input;
                memCount++;
                System.out.println("___________________________");
                System.out.println("added: " + input);
                System.out.println("___________________________");
            }
        }

        sc.close();
    }
}

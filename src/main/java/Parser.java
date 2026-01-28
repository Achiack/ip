public class Parser {

    public static String getCommandWord(String input) {
        return input.split(" ")[0];
    }

    public static String getArguments(String input) {
        return input.substring(input.indexOf(" ") + 1);
    }
}
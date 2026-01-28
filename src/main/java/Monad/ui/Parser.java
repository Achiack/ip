package Monad.ui;


import Monad.commands.*;

public class Parser {


    public static Command parse(String input) throws MonadException {
        String trimmed = input.trim();

        if (trimmed.equals("bye")) {
            return new ByeCommand();
        }

        if (trimmed.equals("list")) {
            return new ListCommand();
        }

        if (trimmed.startsWith("todo")) {
            return parseTodo(trimmed);
        }

        if (trimmed.startsWith("deadline")) {
            return parseDeadline(trimmed);
        }

        if (trimmed.startsWith("event")) {
            return parseEvent(trimmed);
        }

        if (trimmed.startsWith("delete")) {
            return parseDelete(trimmed);
        }

        if (trimmed.startsWith("mark")) {
            return parseMark(trimmed);
        }

        if (trimmed.startsWith("unmark")) {
            return parseUnmark(trimmed);
        }

        throw new MonadException("I'm sorry, but I don't know what that means :-(");
    }


    private static Command parseTodo(String input) throws MonadException {
        String desc = input.substring(4).trim();
        if (desc.isEmpty()) {
            throw new MonadException("The description of a todo cannot be empty.");
        }
        return new TodoCommand(desc);
    }


    private static Command parseDeadline(String input) throws MonadException {
        String[] parts = input.split(" /by ");
        if (parts.length < 2) {
            throw new MonadException("Monad.Tasks.Deadline must have /by");
        }


        String desc = parts[0].substring(8).trim();
        String by = parts[1].trim();


        return new DeadlineCommand(desc, by);
    }


    private static Command parseEvent(String input) throws MonadException {
        String[] partsFrom = input.split(" /from ");
        if (partsFrom.length < 2) {
            throw new MonadException("Monad.Tasks.Event must have /from");
        }

        String desc = partsFrom[0].substring(5).trim();
        String[] partsTo = partsFrom[1].split(" /to ");
        if (partsTo.length < 2) {
            throw new MonadException("Monad.Tasks.Event must have /to");
        }

        String from = partsTo[0].trim();
        String to = partsTo[1].trim();

        return new EventCommand(desc, from, to);
    }


    private static Command parseDelete(String input) throws MonadException {
        try {
            int index = Integer.parseInt(input.substring(6).trim()) - 1;
            return new DeleteCommand(index);
        } catch (NumberFormatException e) {
            throw new MonadException("Please provide a valid task number.");
        }
    }

    private static Command parseMark(String input) throws MonadException {
        try {
            int index = Integer.parseInt(input.substring(5).trim()) - 1;
            return new MarkCommand(index);
        } catch (NumberFormatException e) {
            throw new MonadException("Please provide a valid task number.");
        }
    }

    private static Command parseUnmark(String input) throws MonadException {
        try {
            int index = Integer.parseInt(input.substring(7).trim()) - 1;
            return new UnmarkCommand(index);
        } catch (NumberFormatException e) {
            throw new MonadException("Please provide a valid task number.");
        }
    }
}
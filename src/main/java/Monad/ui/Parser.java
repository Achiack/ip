package Monad.ui;


import Monad.commands.*;

import java.util.Map;

/**
 * Represents the input parser
 */
public class Parser {

    private static final int TODO_PREFIX = 4;
    private static final int DEADLINE_PREFIX = 8;
    private static final int EVENT_PREFIX = 5;
    private static final int DELETE_PREFIX = 6;
    private static final int MARK_PREFIX = 5;
    private static final int UNMARK_PREFIX = 7;
    private static final int FIND_PREFIX = 4;

    private static final Map<String, CommandParser> COMMANDS = Map.of(
            "bye", s -> new ByeCommand(),
            "list", s -> new ListCommand(),
            "todo", Parser::parseTodo,
            "deadline", Parser::parseDeadline,
            "event", Parser::parseEvent,
            "delete", Parser::parseDelete,
            "mark", Parser::parseMark,
            "unmark", Parser::parseUnmark,
            "find", Parser::parseFind
    );

    /**
     * Parses a user input to identify the command used
     * Returns a command
     *
     * @param input The user input to parse
     */
    public static Command parse(String input) throws MonadException {
        String trimmed = input.trim();
        String commandWord = trimmed.split(" ", 2)[0];

        CommandParser parser = COMMANDS.get(commandWord);

        if (parser == null) {
            throw new MonadException("I'm sorry, but I don't know what that means :-(");
        }

        return parser.parse(trimmed);
    }


    /**
     * Parses a todo command.
     *
     * @param input The full user input starting with todo.
     */
    private static Command parseTodo(String input) throws MonadException {
        String desc = input.substring(TODO_PREFIX).trim();
        if (desc.isEmpty()) {
            throw new MonadException("The description of a todo cannot be empty.");
        }
        return new TodoCommand(desc);
    }

    /**
     * Parses a deadline command.
     *
     * @param input The full user input starting with deadline.
     */
    private static Command parseDeadline(String input) throws MonadException {
        String[] parts = input.split(" /by ");
        if (parts.length < 2) {
            throw new MonadException("Monad.Tasks.Deadline must have /by");
        }


        String desc = parts[0].substring(DEADLINE_PREFIX).trim();
        String by = parts[1].trim();


        return new DeadlineCommand(desc, by);
    }

    /**
     * Parses an event command.
     *
     * @param input The full user input starting with event.
     */
    private static Command parseEvent(String input) throws MonadException {
        String[] partsFrom = input.split(" /from ");
        if (partsFrom.length < 2) {
            throw new MonadException("Monad.Tasks.Event must have /from");
        }

        String desc = partsFrom[0].substring(EVENT_PREFIX).trim();
        String[] partsTo = partsFrom[1].split(" /to ");
        if (partsTo.length < 2) {
            throw new MonadException("Monad.Tasks.Event must have /to");
        }

        String from = partsTo[0].trim();
        String to = partsTo[1].trim();

        return new EventCommand(desc, from, to);
    }

    /**
     * Parses a delete command.
     *
     * @param input The full user input starting with delete.
     */
    private static Command parseDelete(String input) throws MonadException {
        try {
            int index = Integer.parseInt(input.substring(DELETE_PREFIX).trim()) - 1;
            return new DeleteCommand(index);
        } catch (NumberFormatException e) {
            throw new MonadException("Please provide a valid task number.");
        }
    }

    /**
     * Parses a mark command.
     *
     * @param input The full user input starting with mark.
     */
    private static Command parseMark(String input) throws MonadException {
        try {
            int index = Integer.parseInt(input.substring(MARK_PREFIX).trim()) - 1;
            return new MarkCommand(index);
        } catch (NumberFormatException e) {
            throw new MonadException("Please provide a valid task number.");
        }
    }

    /**
     * Parses a unmark command.
     *
     * @param input The full user input starting with unmark.
     */
    private static Command parseUnmark(String input) throws MonadException {
        try {
            int index = Integer.parseInt(input.substring(UNMARK_PREFIX).trim()) - 1;
            return new UnmarkCommand(index);
        } catch (NumberFormatException e) {
            throw new MonadException("Please provide a valid task number.");
        }
    }

    private static Command parseFind(String input) throws MonadException {
        String keyword = input.substring(FIND_PREFIX).trim();
        if (keyword.isEmpty()) {
            throw new MonadException("Please provide a keyword to search for.");
        }
        return new FindCommand(keyword);
    }
}
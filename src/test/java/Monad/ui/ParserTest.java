package Monad.ui;

import Monad.commands.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void parse_byeCommand_success() throws MonadException {
        Command c = Parser.parse("bye");
        assertTrue(c instanceof ByeCommand);
    }

    @Test
    public void parse_listCommand_success() throws MonadException {
        Command c = Parser.parse("list");
        assertTrue(c instanceof ListCommand);
    }

    @Test
    public void parse_todoCommand_success() throws MonadException {
        Command c = Parser.parse("todo read book");
        assertTrue(c instanceof TodoCommand);
    }

    @Test
    public void parse_todo_emptyDescription_throwsException() {
        MonadException e = assertThrows(MonadException.class, () -> {
            Parser.parse("todo   ");
        });

        assertEquals("The description of a todo cannot be empty.", e.getMessage());
    }

    @Test
    public void parse_deadlineCommand_success() throws MonadException {
        Command c = Parser.parse("deadline submit report /by 2026-02-01");
        assertTrue(c instanceof DeadlineCommand);
    }

    @Test
    public void parse_deadline_missingBy_throwsException() {
        MonadException e = assertThrows(MonadException.class, () -> {
            Parser.parse("deadline submit report");
        });

        assertEquals("Monad.Tasks.Deadline must have /by", e.getMessage());
    }

    @Test
    public void parse_eventCommand_success() throws MonadException {
        Command c = Parser.parse("event meeting /from 2026-02-01 /to 2026-02-02");
        assertTrue(c instanceof EventCommand);
    }

    @Test
    public void parse_deleteCommand_success() throws MonadException {
        Command c = Parser.parse("delete 2");
        assertTrue(c instanceof DeleteCommand);
    }

    @Test
    public void parse_delete_invalidIndex_throwsException() {
        MonadException e = assertThrows(MonadException.class, () -> {
            Parser.parse("delete abc");
        });

        assertEquals("Please provide a valid task number.", e.getMessage());
    }

    @Test
    public void parse_unknownCommand_throwsException() {
        MonadException e = assertThrows(MonadException.class, () -> {
            Parser.parse("nonsense");
        });

        assertEquals("I'm sorry, but I don't know what that means :-(", e.getMessage());
    }
}
package Monad.tasks;

import Monad.ui.MonadException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an event entry
 */
public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Creates a new event with the given description and start to end datetime.
     *
     * @param description The description of the task
     * @param from The starting date/time for the task
     * @param to The ending date/time for the task
     */
    public Event(String description, String from, String to) throws MonadException {
        super(description, TaskType.EVENT);
        try {
            this.from = LocalDateTime.parse(from);
        }
        catch (DateTimeParseException e) {
            throw new MonadException("Invalid date/time format. Use yyyy-MM-ddTHH:mm");
        }
        try {
            this.to = LocalDateTime.parse(to);
        }
        catch (DateTimeParseException e) {
            throw new MonadException("Invalid date/time format. Use yyyy-MM-ddTHH:mm");
        }
    }

    /**
     * Converts the event into a string format
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return super.toString() + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }

    /**
     * Converts the event into a format for file storage
     */
    @Override
    public String toFileString() {
        return "E | "
                + (isDone ? "1" : "0") + " | "
                + description + " | "
                + from + " | "
                + to;
    }
}

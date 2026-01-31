package Monad.tasks;

import Monad.ui.MonadException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a deadline entry
 */
public class Deadline extends Task {
    protected LocalDate by;
    /**
     * Creates a new Deadline with the given description and deadline.
     *
     * @param description The description of the task
     * @param by The deadline date/time for the task
     */
    public Deadline(String description, String by) throws MonadException {
        super(description, TaskType.DEADLINE);
        try {
            this.by = LocalDate.parse(by);
        }
        catch (DateTimeParseException e) {
            throw new MonadException("Invalid date format. Use yyyy-MM-dd");
        }
    }

    /**
     * Converts the deadline into a string format
     */
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return super.toString() + " (by: " + by.format(formatter) + ")";
    }

    /**
     * Converts the deadline into a format for file storage
     */
    @Override
    public String toFileString() {
        return "D | "
                + (isDone ? "1" : "0") + " | "
                + description + " | "
                + by;
    }
}

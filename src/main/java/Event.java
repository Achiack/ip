import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to) throws MonadException{
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return super.toString() + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }

    @Override
    public String toFileString() {
        return "E | "
                + (isDone ? "1" : "0") + " | "
                + description + " | "
                + from + " - "
                + to;
    }
}

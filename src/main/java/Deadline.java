import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected LocalDate by;

    public Deadline(String description, String by) throws MonadException{
        super(description, TaskType.DEADLINE);
        try {
            this.by = LocalDate.parse(by); // expects yyyy-MM-dd
        }
        catch (DateTimeParseException e) {
            throw new MonadException("Invalid date format. Use yyyy-MM-dd");
        }
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return super.toString() + " (by: " + by.format(formatter) + ")";
    }

    @Override
    public String toFileString() {
        return "D | "
                + (isDone ? "1" : "0") + " | "
                + description + " | "
                + by;
    }
}

import java.io.IOException;
import java.time.LocalDate;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;


    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Deadline d = null;
        try {
            d = new Deadline(description, by);
        }
        catch (MonadException e) {
            System.out.println("Error");
        }
        tasks.add(d);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showAdd(d, tasks.size());
    }
}
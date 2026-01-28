import java.io.IOException;

public class UnmarkCommand extends Command{
    private final int index;
    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Task task = tasks.get(index);
        task.unmark();
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showUnmark(task);
    }
}

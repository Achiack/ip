import java.io.IOException;

public class MarkCommand extends Command{
    private final int index;
    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Task task = tasks.get(index);
        task.markAsDone();
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error loading file");
        }
        ui.showMark(task);
    }
}

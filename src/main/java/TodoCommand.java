import java.io.IOException;

public class TodoCommand extends Command {
    private final String description;


    public TodoCommand(String description) {
        this.description = description;
    }


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Todo todo = new Todo(description);
        tasks.add(todo);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error");
        }
        ui.showAdd(todo, tasks.size());
    }
}
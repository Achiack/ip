package Monad.commands;

import Monad.tasks.TaskList;
import Monad.tasks.Todo;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that creates a todo entry.
 * <p>
 * When executed, this command adds a todo to the list of tasks.
 */
public class TodoCommand extends Command {
    private final String description;

    /**
     * Creates a new TodoCommand with the given description.
     *
     * @param description The description of the task
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes a command to create an todo entry
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        assert tasks != null;
        assert ui != null;
        assert storage != null;

        Todo todo = new Todo(description);
        tasks.add(todo);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showAdd(todo, tasks.size());
    }
}
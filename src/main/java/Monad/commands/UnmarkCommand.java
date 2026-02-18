package Monad.commands;

import Monad.tasks.Task;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that marks a task as not completed.
 * <p>
 * When executed, this command marks a task as not completed.
 */
public class UnmarkCommand extends Command{
    private final int index;
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes a command to mark a task as not completed
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        assert tasks != null;
        assert ui != null;
        assert storage != null;

        Task task = tasks.get(index);
        task.unmark();
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showUnmark(task);
        return "OK, I've marked this task as not done yet:\n" +
                task.toString();
    }
}

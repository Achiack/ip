package Monad.commands;

import Monad.tasks.Task;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that marks a task as completed.
 * <p>
 * When executed, this command marks a task as completed.
 */
public class MarkCommand extends Command{
    private final int index;
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes a command to mark a task as completed
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Task task = tasks.get(index);
        task.markAsDone();
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showMark(task);
    }
}

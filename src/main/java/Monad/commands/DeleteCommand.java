package Monad.commands;

import Monad.tasks.Task;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that deletes an entry.
 * <p>
 * When executed, this command deletes an entry from the list of tasks.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Creates a new DeadlineCommand with the given description and deadline.
     *
     * @param index index of the entry to delete
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes a command to delete an entry
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

        Task removed = tasks.get(index);
        tasks.remove(index);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showDelete(removed, tasks.size());
    }
}
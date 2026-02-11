package Monad.commands;

import Monad.tasks.Task;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that find a task in the task list.
 * <p>
 * When executed, this command searches for tasks containing the keyword
 */
public class FindCommand extends Command {
    private String taskName;
    /**
     * Creates a new FindCommand with the task name to search for
     *
     * @param taskName The keyword to search for
     */
    public FindCommand(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Finds a task in the task list
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
        ui.showFindResults(tasks, taskName);
    }
}
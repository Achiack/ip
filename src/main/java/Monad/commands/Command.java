package Monad.commands;

import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

/**
 * Represents the command that terminates the application.
 */
public abstract class Command {
    /**
     * Executes a command and shows the result on the UI
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws MonadException;

    /**
     * Tells the UI to keep running
     */
    public boolean isExit() {
        return false;
    }
}
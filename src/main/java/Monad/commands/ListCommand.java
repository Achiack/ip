package Monad.commands;

import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

/**
 * Represents the command that displays a list of tasks.
 * <p>
 * When executed, this command displays the list of tasks.
 */
public class ListCommand extends Command {

    /**
     * Executes a command to list out all the tasks
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
    }
}
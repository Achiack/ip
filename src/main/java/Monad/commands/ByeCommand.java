package Monad.commands;

import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

/**
 * Represents the command that terminates the application.
 * <p>
 * When executed, this command displays a goodbye message to the user
 * and exits the program
 */
public class ByeCommand extends Command {

    /**
     * Executes a command and shows a goodbye message
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
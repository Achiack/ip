package Monad.commands;

import Monad.tasks.Deadline;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that creates a deadline entry.
 * <p>
 * When executed, this command adds a deadline to the list of tasks.
 */
public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    /**
     * Creates a new DeadlineCommand with the given description and deadline.
     *
     * @param description The description of the task
     * @param by The deadline date/time for the task
     */
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes a command to create a deadline entry
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

        Deadline deadline = null;
        try {
            deadline = new Deadline(description, by);
        }
        catch (MonadException e) {
            System.out.println("Error");
        }

        tasks.add(deadline);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showAdd(deadline, tasks.size());
    }
}
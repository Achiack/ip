package Monad.commands;

import Monad.tasks.Event;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that creates a event entry.
 * <p>
 * When executed, this command adds a event to the list of tasks.
 */
public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Creates a new EventCommand with the given description and start and end datetime.
     *
     * @param description The description of the task
     * @param from The starting date/time for the task
     * @param to The ending date/time for the task
     */
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes a command to create an event entry
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
        
        Event event = null;
        try {
            event = new Event(description, from, to);
        }
        catch (MonadException err) {
            System.out.println("Error");
        }
        tasks.add(event);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException err) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showAdd(event, tasks.size());
    }
}
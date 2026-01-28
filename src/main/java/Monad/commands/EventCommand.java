package Monad.commands;

import Monad.tasks.Event;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;


public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;


    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Event e = null;
        try {
            e = new Event(description, from, to);
        }
        catch (MonadException err) {
            System.out.println("Error");
        }
        tasks.add(e);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException err) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showAdd(e, tasks.size());
    }
}
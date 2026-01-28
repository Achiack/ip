package Monad.commands;

import Monad.tasks.TaskList;
import Monad.tasks.Todo;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

public class TodoCommand extends Command {
    private final String description;


    public TodoCommand(String description) {
        this.description = description;
    }


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        Todo todo = new Todo(description);
        tasks.add(todo);
        try {
            storage.save(tasks.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
        ui.showAdd(todo, tasks.size());
    }
}
package Monad.commands;

import Monad.tasks.Task;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.ui.Ui;

import java.io.IOException;

public class MarkCommand extends Command{
    private final int index;
    public MarkCommand(int index) {
        this.index = index;
    }

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

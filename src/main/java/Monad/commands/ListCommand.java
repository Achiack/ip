package Monad.commands;

import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
    }
}
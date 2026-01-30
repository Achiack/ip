package Monad.commands;

import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

public class ByeCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }

}
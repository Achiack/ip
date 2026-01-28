package Monad.commands;

import Monad.ui.MonadException;
import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException;

    public boolean isExit() {
        return false;
    }
}
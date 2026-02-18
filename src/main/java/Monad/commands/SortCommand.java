package Monad.commands;

import Monad.tasks.HasDate;
import Monad.tasks.Task;
import Monad.tasks.TaskList;
import Monad.ui.MonadException;
import Monad.ui.Ui;
import Monad.ui.Storage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class SortCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        System.out.println(tasks);
        List<Task> sortedDeadlines = tasks.sortByDate();
        ui.showSortedDeadlines(sortedDeadlines);
    }
}

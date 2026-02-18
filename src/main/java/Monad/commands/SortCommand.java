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
    public String execute(TaskList tasks, Ui ui, Storage storage) throws MonadException {
        System.out.println(tasks);
        List<Task> sortedDeadlines = tasks.sortByDate();
        StringBuilder sb = new StringBuilder();

        sb.append("Here are your deadlines sorted chronologically:")
                .append(System.lineSeparator());

        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(tasks.get(i))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}

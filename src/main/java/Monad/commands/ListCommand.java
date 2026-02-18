package Monad.commands;

import Monad.ui.Storage;
import Monad.tasks.TaskList;
import Monad.ui.Ui;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents the command that displays a list of tasks.
 * <p>
 * When executed, this command displays the list of tasks.
 */
public class ListCommand extends Command {

    /**
     * Executes a command to list out all the tasks
     *
     * @param tasks List of tasks
     * @param ui UI object used to display the result
     * @param storage Storage to keep lists of tasks
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null;
        assert ui != null;
        assert storage != null;
        return IntStream.range(0, tasks.size())
                .mapToObj(i -> (i + 1) + ". " + tasks.get(i))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
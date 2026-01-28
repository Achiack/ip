package Monad.ui;

import Monad.commands.Command;
import Monad.tasks.TaskList;

public class Monad {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Monad(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);


        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();


        boolean isExit = false;
        while (true) {
            try {
                String input = ui.readCommand();
                Command command = Parser.parse(input);
                command.execute(tasks, ui, storage);

                if (command.isExit()) {
                    break;
                }

            } catch (MonadException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Monad("data/monad.txt").run();
    }
}

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws MonadException;

    public boolean isExit() {
        return false;
    }
}
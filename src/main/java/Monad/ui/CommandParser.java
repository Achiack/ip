package Monad.ui;

import Monad.commands.Command;

@FunctionalInterface
public interface CommandParser {
    Command parse(String input) throws MonadException;
}
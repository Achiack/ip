package Monad.tasks;

import Monad.ui.MonadException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeadlineTest {

    @Test
    public void toString_correctFormat() throws MonadException {
        Deadline d = new Deadline("submit report", "2026-02-01");

        String output = d.toString();

        assertTrue(output.contains("submit report"));
        assertTrue(output.contains("Feb 01 2026"));
    }

    @Test
    public void constructor_invalidDate_throwsException() {
        assertThrows(MonadException.class, () -> {
            new Deadline("submit report", "not-a-date");
        });
    }
}
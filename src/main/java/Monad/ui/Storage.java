package Monad.ui;

import Monad.tasks.Deadline;
import Monad.tasks.Event;
import Monad.tasks.Task;
import Monad.tasks.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the Storage Handler
 */
public class Storage {
    private final File file;

    /**
     * Creates a new Storage instance
     *
     * @param filePath The path location of the storage file
     */
    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Loads an array from the Storage file
     */
    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();


        file.getParentFile().mkdirs();


        if (!file.exists()) {
            file.createNewFile();
            return tasks;
        }


        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Task task = parseTask(line);
                tasks.add(task);
            }
        }


        return tasks;
    }

    /**
     * Saves tasks to the storage file
     *
     * @param tasks The list of tasks to save to the storage file
     */
    public void save(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(file);


        for (Task task : tasks) {
            fw.write(task.toFileString());
            fw.write(System.lineSeparator());
        }


        fw.close();
    }

    /**
     * Parses one line of information from the storage file
     *
     * @param line The line to parse
     */
    private Task parseTask(String line) {
        String[] parts = line.split(" \\| ");


        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String desc = parts[2];


        Task task;

        try {
            switch (type) {
                case "T":
                    task = new Todo(desc);
                    break;
                case "D":
                    task = new Deadline(desc, parts[3]);
                    break;
                case "E":
                    task = new Event(desc, parts[3], parts[4]);
                    break;
                default:
                    throw new IllegalArgumentException("Corrupted data file");
            }
        }
        catch (MonadException e) {
            throw new IllegalArgumentException("Corrupted data file: " + e.getMessage());
        }


        if (isDone) {
            task.markAsDone();
        }


        return task;
    }
}

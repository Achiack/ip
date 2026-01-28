import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final File file;


    public Storage(String filePath) {
        this.file = new File(filePath);
    }


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


    public void save(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(file);


        for (Task task : tasks) {
            fw.write(task.toFileString());
            fw.write(System.lineSeparator());
        }


        fw.close();
    }


// --- Helper ---


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

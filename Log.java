import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static Log instance;
    private StringBuilder logEntries;

    private Log() {
        logEntries = new StringBuilder();
    }

    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void addEntry(String entry) {
        logEntries.append(entry).append("\n");
    }

    public void writeLog(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(logEntries.toString());
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }
}

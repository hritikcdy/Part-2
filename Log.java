public class Log {
    private static Log instance;
    private StringBuilder logContent;

    private Log() {
        logContent = new StringBuilder();
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void logEvent(String event) {
        logContent.append(event).append("\n");
    }

    public String getLog() {
        return logContent.toString();
    }

    public void writeLogToFile(String filename) {
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(filename), logContent.toString().getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

package LoggerFramework2.observer;

public class FileSinkObserver implements SinkObserver {
    @Override
    public void log(int level, String message) {
        System.out.println("Printing on console: level- " + level + " message: " + message);
    }
}

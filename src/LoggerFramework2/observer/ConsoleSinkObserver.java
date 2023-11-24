package LoggerFramework2.observer;

public class ConsoleSinkObserver implements SinkObserver {
    @Override
    public void log(int level, String message) {
        System.out.println("Printing on console: level- " + level + " message: " + message);
    }
}

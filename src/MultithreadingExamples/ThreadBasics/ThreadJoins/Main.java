package MultithreadingExamples.ThreadBasics.ThreadJoins;

public class Main {
    static TimerThread timerThread = new TimerThread();

    public static void main(String[] args) {
        start();
        try {
            System.out.println(Thread.currentThread().getName() + " sleeping for some time");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stop();
    }

    private static void start() {
        timerThread.start();
    }

    private static void stop() {
        timerThread.shouldRun = false;
        timerThread = null;
    }
}

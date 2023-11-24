package MultithreadingExamples.ThreadBasics.ThreadJoins;

public class TimerThread extends Thread{
    public boolean shouldRun;

    public TimerThread() {
        super("TimerThread");
        this.shouldRun = true;
    }

    @Override
    public void run() {
        while (shouldRun) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("shouldRun " + shouldRun);
            System.out.println(Thread.currentThread().getName() + " is printing");
        }
        System.out.println(Thread.currentThread().getName() + " is exiting");
    }
}

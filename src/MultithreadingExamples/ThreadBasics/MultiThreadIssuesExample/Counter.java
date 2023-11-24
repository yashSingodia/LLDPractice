package MultithreadingExamples.ThreadBasics.MultiThreadIssuesExample;

public class Counter implements Runnable{
    private int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + " increasing the counter");
            counter++;
            System.out.println(Thread.currentThread().getName() + " increased the counter to " + counter);
        }
    }
    public int getCounter() {
        return counter;
    }
}

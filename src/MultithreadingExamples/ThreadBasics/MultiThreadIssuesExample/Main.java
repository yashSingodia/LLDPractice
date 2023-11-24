package MultithreadingExamples.ThreadBasics.MultiThreadIssuesExample;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.setName("alice");
        t2.setName("bob");

        t1.start();
        t2.start();
    }
}

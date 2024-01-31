package ThreadBasics.MonitorLock;

public class MonitorLock {
    public synchronized void task1 () {
        System.out.println("starting task1 by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("completing task1 by thread " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2() {
        System.out.println("task 2 - before synchronized by thread " + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("task2 - inside synchronized " + Thread.currentThread().getName());
        }
    }
    public void task3() {
        System.out.println("inside task 3 by " + Thread.currentThread().getName());
    }
}

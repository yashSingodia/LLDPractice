package Lec1.Priority;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->
        {
            System.out.println("thread " + Thread.currentThread().getName());
        });

        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
//        ThreadGroup threadGroup = new ThreadGroup();

    }
}

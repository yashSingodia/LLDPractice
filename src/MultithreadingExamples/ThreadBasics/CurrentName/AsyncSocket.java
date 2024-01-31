package ThreadBasics.CurrentName;

public class AsyncSocket extends Thread {

    public AsyncSocket(String name) {
        super(name);
        System.out.println("In the constructor " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.printf("Read data from a socket, Thread Name %s%n", Thread.currentThread().getName());
    }

    public String getResult() {

        String reader = Thread.currentThread().getName();

        if (reader.startsWith("Reader")) {
            System.out.printf("In the getResult method for threadName %s%n", reader);
            return "reading";
        } else {
            return "";
        }
    }
}

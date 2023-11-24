package MultithreadingExamples.ThreadBasics.CurrentName;

public class Main extends Thread{
    private AsyncSocket asyncSocket;

    public Main(AsyncSocket asyncSocket) {
        super("ReaderThread");
        this.asyncSocket = asyncSocket;
    }

    @Override
    public void run() {
        System.out.println("Data is " + asyncSocket.getResult());
    }

    public static void main(String[] args) {
        System.out.println("Main Thread Name " + Thread.currentThread().getName());
        AsyncSocket asr = new AsyncSocket("AsyncThread");
        asr.start();
        new Main(asr).start();
    }

}

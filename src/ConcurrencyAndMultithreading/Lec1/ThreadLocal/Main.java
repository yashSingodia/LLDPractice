package Lec1.ThreadLocal;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
    }

    public static class MyThread implements Runnable {

        @Override
        public void run() {

        }
    }
}

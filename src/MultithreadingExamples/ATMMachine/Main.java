package MultithreadingExamples.ATMMachine;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        AccountHolder accountHolder = new AccountHolder(account);

        System.out.println("Main Thread " + Thread.currentThread().getName());

        Thread t1 = new Thread(accountHolder);
        Thread t2 = new Thread(accountHolder);

        t1.setName("alice");
        t2.setName("bob");

        t1.start();
        t2.start();
    }
}

package MultithreadingExamples.ATMMachine;

public class AccountHolder implements Runnable{
    private Account account;

    public AccountHolder(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 1; i<=4; i++) {
            makeWithdrawl(2000);
            if (account.getBalance() < 0) {
                System.out.println("Negative balance in the account");
            }
            System.out.println();
        }
    }

    private void makeWithdrawl(int amount) {
        if (amount <= account.getBalance()) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw of " + amount + " --balance is " + account.getBalance());
        } else {
            System.out.println("Not enough amount in account to withdraw for " + Thread.currentThread().getName());
        }
    }
}

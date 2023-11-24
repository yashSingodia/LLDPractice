package OrderManagementSystem.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        return true;
    }
}

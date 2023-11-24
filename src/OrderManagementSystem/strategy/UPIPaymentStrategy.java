package OrderManagementSystem.strategy;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return false;
    }
}

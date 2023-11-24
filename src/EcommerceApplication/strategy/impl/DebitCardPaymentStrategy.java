package EcommerceApplication.strategy.impl;

import EcommerceApplication.strategy.PaymentStrategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}

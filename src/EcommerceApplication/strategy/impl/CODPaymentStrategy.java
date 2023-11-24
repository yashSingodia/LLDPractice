package EcommerceApplication.strategy.impl;

import EcommerceApplication.strategy.PaymentStrategy;

public class CODPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}

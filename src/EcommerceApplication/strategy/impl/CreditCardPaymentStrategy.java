package EcommerceApplication.strategy.impl;

import EcommerceApplication.strategy.PaymentStrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}

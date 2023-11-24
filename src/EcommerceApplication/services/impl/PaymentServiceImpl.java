package EcommerceApplication.services.impl;

import EcommerceApplication.services.PaymentService;
import EcommerceApplication.strategy.PaymentStrategy;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentStrategy paymentStrategy;

    public PaymentServiceImpl(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public boolean makePayment(double amount) {
        return paymentStrategy.pay(amount);
    }
}

package FlashSale.main.java.service;

import strategy.PaymentStrategy;

public class PaymentService {
    private final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean payAmount(double amount) {
        return paymentStrategy.pay(amount);
    }
}

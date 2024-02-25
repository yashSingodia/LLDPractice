package FlashSale.main.java.factory;

import exceptions.InvalidPaymentStrategyException;
import models.PaymentMethod;
import strategy.CreditCardPaymentStrategy;
import strategy.PaymentStrategy;
import strategy.UPIPaymentStrategy;

public class PaymentStrategyFactory {
    private final PaymentMethod paymentMethod;

    public PaymentStrategyFactory(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStrategy choosePaymentStrategy() throws InvalidPaymentStrategyException {
        switch (paymentMethod) {
            case UPI:
                return new UPIPaymentStrategy();
            case CREDIT_CARD:
                return new CreditCardPaymentStrategy();
            default:
                throw new InvalidPaymentStrategyException("");
        }
    }
}

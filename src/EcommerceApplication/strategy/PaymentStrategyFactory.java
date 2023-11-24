package EcommerceApplication.strategy;

import EcommerceApplication.enums.PaymentMethod;
import EcommerceApplication.exceptions.IncorrectPaymentMethodException;
import EcommerceApplication.strategy.impl.CODPaymentStrategy;
import EcommerceApplication.strategy.impl.CreditCardPaymentStrategy;
import EcommerceApplication.strategy.impl.DebitCardPaymentStrategy;
import EcommerceApplication.strategy.impl.UPIPaymentStrategy;

public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case COD:
                return new CODPaymentStrategy();
            case UPI:
                return new UPIPaymentStrategy();
            case DEBIT_CARD:
                return new DebitCardPaymentStrategy();
            case CREDIT_CARD:
                return new CreditCardPaymentStrategy();
            default:
                throw new IncorrectPaymentMethodException("Payment method is not correct");
        }

    }
}

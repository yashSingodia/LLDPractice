package Ecommerce.models;

import java.util.HashMap;

public class PincodeServiceability {
    private final String destinationPincode;
    private final PaymentMethod paymentMethod;

    public PincodeServiceability(String destinationPincode, PaymentMethod paymentMethod) {
        this.destinationPincode = destinationPincode;
        this.paymentMethod = paymentMethod;
    }

    public String getDestinationPincode() {
        return destinationPincode;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}

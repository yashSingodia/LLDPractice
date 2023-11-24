package Ecommerce.models;

import Ecommerce.util.RandomIdGeneratorUtil;

public class Buyer {
    private final String buyerId;
    private final String buyerName;
    private PaymentMethod paymentMethod;
    private final Address address;

    public Buyer(String buyerName, PaymentMethod paymentMethod, Address address) {
        this.buyerId = RandomIdGeneratorUtil.generateId();
        this.buyerName = buyerName;
        this.paymentMethod = paymentMethod;
        this.address = address;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Address getAddress() {
        return address;
    }
}

package Ecommerce.models;

public class Order {

    private final String orderId;
    private final String userId;
    private final String buyerId;
    private final String productId;
    private final int quantity;
    private final PaymentMethod paymentMethod;

    public Order(String orderId, String userId, String buyerId, String productId, int quantity, PaymentMethod paymentMethod) {
        this.orderId = orderId;
        this.userId = userId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}

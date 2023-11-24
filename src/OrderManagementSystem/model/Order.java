package OrderManagementSystem.model;

import java.util.Map;

public class Order {
    private final String orderId;
    private final User user;
    private final Invoice invoice;
    private final OrderStatus orderStatus;

    public Order(String orderId, User user, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.user = user;
        this.orderStatus = orderStatus;
        this.invoice = new Invoice(this);
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}

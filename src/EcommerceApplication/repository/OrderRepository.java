package EcommerceApplication.repository;

import EcommerceApplication.models.Order;

import java.util.HashMap;

public class OrderRepository {

    private HashMap<String, Order> ordersMap;

    public OrderRepository() {
        this.ordersMap = new HashMap<>();
    }

    public Order createOrder(Order order) {
        if (ordersMap.containsKey(order.getOrderId())) {
            throw new RuntimeException();
        }
        ordersMap.put(order.getOrderId(), order);
        return order;
    }

    public Order getOrder(String orderId) {
        return ordersMap.get(orderId);
    }
}

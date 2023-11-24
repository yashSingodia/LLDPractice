package OrderManagementSystem.service;

import OrderManagementSystem.model.Order;

public interface OrderService {
    void addOrder(Order order);

    void removeOrder(Order order);

    void checkout(Order order);
}

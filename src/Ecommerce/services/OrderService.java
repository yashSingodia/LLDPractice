package Ecommerce.services;

import Ecommerce.models.Order;

public interface OrderService {
    Order addOrder(Order order);

    Order getOrder(String orderId);
}

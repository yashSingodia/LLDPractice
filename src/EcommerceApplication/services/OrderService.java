package EcommerceApplication.services;

import EcommerceApplication.models.Buyer;
import EcommerceApplication.models.Order;

public interface OrderService {
    Order addOrder(Order order);

    Order getOrder(String orderId);

    void checkout(Buyer buyer);
}

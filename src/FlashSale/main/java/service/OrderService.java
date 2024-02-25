package FlashSale.main.java.service;

import repository.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean generateInvoice() {
        return orderRepository.generateInvoice();
    }
}

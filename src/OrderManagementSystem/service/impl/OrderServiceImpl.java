package OrderManagementSystem.service.impl;

import OrderManagementSystem.model.Order;
import OrderManagementSystem.service.InventoryService;
import OrderManagementSystem.service.OrderService;
import OrderManagementSystem.service.PaymentService;
import OrderManagementSystem.service.WarehouseService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final List<Order> orderList;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public OrderServiceImpl(InventoryService inventoryService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.orderList = new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orderList.remove(order);
    }

    @Override
    public void checkout(Order order) {

        if (paymentService.makePayment(order.getInvoice().getTotalFinalPrice())) {
            // // remove item from inventory
        }


    }
}

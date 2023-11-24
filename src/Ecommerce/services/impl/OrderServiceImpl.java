package Ecommerce.services.impl;

import Ecommerce.models.Order;
import Ecommerce.repository.OrderRepository;
import Ecommerce.services.BuyerService;
import Ecommerce.services.OrderService;
import Ecommerce.services.PincodeServiceablityService;
import Ecommerce.services.ProductService;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;
    private PincodeServiceablityService pincodeServiceablityService;
    private BuyerService buyerService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService, PincodeServiceablityService pincodeServiceablityService, BuyerService buyerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.pincodeServiceablityService = pincodeServiceablityService;
        this.buyerService = buyerService;
    }

    @Override
    public Order addOrder(Order order) {

        String sourcePincode = productService.getProduct(order.getProductId()).getAddress().getPinCode();
        String destinationPincode = buyerService.getBuyer(order.getBuyerId()).getAddress().getPinCode();

        if (!pincodeServiceablityService.chcekIfSourceAndDestinationPincodeMatch(sourcePincode, destinationPincode,
                order.getPaymentMethod())) {
            throw new RuntimeException();
        }

        if (productService.checkInventory(order.getQuantity(), order.getProductId())) {
            return orderRepository.createOrder(order);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }
}

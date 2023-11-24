package EcommerceApplication.services.impl;

import EcommerceApplication.enums.PaymentMethod;
import EcommerceApplication.exceptions.InsufficientInventoryException;
import EcommerceApplication.exceptions.PaymentFailedException;
import EcommerceApplication.models.Buyer;
import EcommerceApplication.models.Order;
import EcommerceApplication.repository.OrderRepository;
import EcommerceApplication.services.BuyerService;
import EcommerceApplication.services.OrderService;
import EcommerceApplication.services.PaymentService;
import EcommerceApplication.services.ProductService;
import EcommerceApplication.strategy.PaymentStrategyFactory;

import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final BuyerService buyerService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService, PaymentService paymentService, BuyerService buyerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.paymentService = paymentService;
        this.buyerService = buyerService;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }

    @Override
    public void checkout(Buyer user) {
        synchronized (this) {
            validateProductsInInventory(user);
            Integer totalAmount = user.getCart().getTotalAmount();
            if (paymentService.makePayment(totalAmount)) {
                Order order = new Order(
                        user.getBuyerId(),
                        user.getCart(),
                        PaymentStrategyFactory.getPaymentStrategy(PaymentMethod.CREDIT_CARD),
                        user.getAddress());

                addOrder(order);
                updateProductsInInventory(user.getCart().getCartItems());
                addOrderInUser(user.getBuyerId(), order.getOrderId());
                System.out.println("User checkedout and order is successfully created for " + user.getBuyerName());
            } else {
                throw new PaymentFailedException("Payment not completed. Please try again");
            }
        }
    }

    private void addOrderInUser(String userId, String orderId) {
        buyerService.addOrderInHistory(userId, orderId);
    }

    private void updateProductsInInventory(Map<String, Integer> cartItems) {
        // removing products from inventory
        productService.updateProductsInInventory(cartItems);
    }

    private void validateProductsInInventory(Buyer user) {
        Map<String, Integer> cartItems = user.getCart().getCartItems();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            if (!productService.checkSufficientInventoryForProduct(entry.getValue(), entry.getKey())) {
                throw new InsufficientInventoryException("");
            }
        }
    }
}

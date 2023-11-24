package EcommerceApplication;

import EcommerceApplication.models.Address;
import EcommerceApplication.models.Buyer;
import EcommerceApplication.models.Product;
import EcommerceApplication.repository.BuyerRepository;
import EcommerceApplication.repository.OrderRepository;
import EcommerceApplication.repository.ProductRepository;
import EcommerceApplication.services.*;
import EcommerceApplication.services.impl.*;
import EcommerceApplication.strategy.impl.CreditCardPaymentStrategy;

import java.util.List;

public class EcommerceApplication {

    public static void main(String[] args) {

        System.out.println("*** Starting Application ***");

        Buyer user = new Buyer("Yash",
                "email",
                "password",
                new Address("address", "pincode"));

        Product laptop = new Product("Laptop", 100, 500);

        BuyerRepository buyerRepository = new BuyerRepository();
        AuthnService inputValidatorService = new AuthnServiceImpl();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();

        ProductService productService = new ProductServiceImpl(productRepository);
        PaymentService paymentService = new PaymentServiceImpl(new CreditCardPaymentStrategy());
        CartService cartService = new CartServiceImpl(user.getCart(), productService);


        BuyerService buyerService = new BuyerServiceImpl(
                buyerRepository,
                inputValidatorService);

        OrderService orderService = new OrderServiceImpl(orderRepository, productService, paymentService, buyerService);

        buyerService.addBuyer(user);
        productService.addProduct(laptop);
        cartService.addItemsToCart(laptop.getProductId(), 10);
        orderService.checkout(user);


        List<String> orderId = buyerService.getOrderHistory(user.getBuyerId());

        System.out.println();
        System.out.println("------ Printing Order History for user ----- " + user.getBuyerName());
        for (String oId : orderId) {
            System.out.println(orderService.getOrder(oId));
        }

    }
}

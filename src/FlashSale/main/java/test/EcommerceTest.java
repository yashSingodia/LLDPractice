package FlashSale.main.java.test;

import exceptions.DealAlreadyPresentException;
import exceptions.DealFinishedException;
import exceptions.DealNotFoundException;
import exceptions.UserNotFoundException;
import models.Deal;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.DealRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.UserRepository;
import service.*;
import strategy.UPIPaymentStrategy;


public class EcommerceTest {

    private static UserService userService;
    private static UserRepository userRepository;
    private static DealService dealService;
    private static ProductService productService;
    private static PaymentService paymentService;
    private static ProductRepository productRepository;
    private static DealRepository dealRepository;
    private static OrderRepository orderRepository;
    private static OrderService orderService;

    @BeforeAll
    public static void setup() {
        userRepository = new UserRepository();
        productRepository = new ProductRepository();
        dealRepository = new DealRepository();
        orderRepository = new OrderRepository();


        productService = new ProductService(productRepository);
        paymentService = new PaymentService(new UPIPaymentStrategy());
        orderService = new OrderService(orderRepository);

        userService = new UserService(userRepository);
        dealService = new DealService(dealRepository, userService, paymentService, productService, orderService);
    }

    @Test
    public void testUserCreation() throws UserNotFoundException {
        User user = User.builder().userId("Yash").build();

        userService.addUser(user.getUserId(), user);

        User returnedUser = userService.getUser(user.getUserId());
        Assertions.assertEquals(user.getUserId(), returnedUser.getUserId());
    }

    @Test
    public void testDealCreation() throws DealNotFoundException, DealFinishedException, DealAlreadyPresentException {

        Deal deal = Deal.builder()
                .dealId("")
                .productId("")
                .price(100)
                .endTimeStamp(123)
                .quantity(12)
                .build();

        dealService.createDeal(deal.getDealId(), deal);

        Deal returnedDeal = dealService.getDeal(deal.getDealId());

        Assertions.assertEquals(deal.getDealId(), returnedDeal.getDealId());
    }

    @Test
    public void testDealExpiry() throws DealAlreadyPresentException, DealNotFoundException {

        Deal deal = Deal.builder()
                .dealId("")
                .productId("")
                .price(100)
                .endTimeStamp(100)
                .quantity(12)
                .build();

        dealService.createDeal(deal.getDealId(), deal);

        Deal returnedDeal = null;
        boolean exceptionOccured = false;
        try {
            returnedDeal = dealService.getDeal(deal.getDealId());
        } catch (DealFinishedException e) {
            exceptionOccured = true;
        }

        Assertions.assertEquals(exceptionOccured, true);
    }
}

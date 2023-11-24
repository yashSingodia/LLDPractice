package OrderManagementSystem;



import OrderManagementSystem.model.*;
import OrderManagementSystem.service.*;
import OrderManagementSystem.service.impl.*;
import OrderManagementSystem.strategy.CreditCardPaymentStrategy;


public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory("I1");

        Address address = new Address("", "", "", "");
        User user = new User("User1", "Yash", address);

        UserService userService = new UserServiceImpl();
        userService.addUser(user);

        Cart cart = new Cart();

        CartService cartService = new CartServiceImpl(cart);
        cartService.addItemsToCart("C1", 5);

        userService.addCart(user, cart);

        Order order = new Order(
                "O1",
                user,
                OrderStatus.ORDERED
        );

        InventoryService inventoryService = new InventoryServiceImpl(inventory);
        PaymentService paymentService = new PaymentServiceImpl(new CreditCardPaymentStrategy());

        OrderService orderService = new OrderServiceImpl(inventoryService, paymentService);
        orderService.addOrder(order);

        orderService.checkout(order);

    }
}

package EcommerceApplication.models;

import EcommerceApplication.strategy.PaymentStrategy;
import EcommerceApplication.util.RandomIdGeneratorUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

    private final String orderId;
    private final String buyerId;
    private final Cart cart;
    private final PaymentStrategy paymentMethod;
    private final Address deliveryAddress;

    public Order(String buyerId, Cart cart, PaymentStrategy paymentMethod, Address deliveryAddress) {
        this.cart = cart;
        this.deliveryAddress = deliveryAddress;
        this.orderId = RandomIdGeneratorUtil.generateId();
        this.buyerId = buyerId;
        this.paymentMethod = paymentMethod;
    }
}

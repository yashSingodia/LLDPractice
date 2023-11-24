package EcommerceApplication.models;

import EcommerceApplication.util.RandomIdGeneratorUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Buyer {
    private final String buyerId;
    private final String buyerName;
    private final String email;
    private final String password;
    private final Address address;
    private final Cart cart;
    private final List<String> orderIds;


    public Buyer(String buyerName, String email, String password, Address address) {
        this.email = email;
        this.password = password;
        this.cart = new Cart();
        this.orderIds = new ArrayList<>();
        this.buyerId = RandomIdGeneratorUtil.generateId();
        this.buyerName = buyerName;
        this.address = address;
    }
}

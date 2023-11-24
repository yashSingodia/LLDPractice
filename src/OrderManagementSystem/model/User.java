package OrderManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private final String name;
    private final Address address;
    private Cart cartDetails;
    private final List<Integer> orderIds;

    public User(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orderIds = new ArrayList<>();
    }

    public void setCartDetails(Cart cartDetails) {
        this.cartDetails = cartDetails;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Cart getCartDetails() {
        return cartDetails;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }
}

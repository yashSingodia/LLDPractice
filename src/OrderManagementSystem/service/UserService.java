package OrderManagementSystem.service;

import OrderManagementSystem.model.Cart;
import OrderManagementSystem.model.User;

public interface UserService {
    void addUser(User user);
    User getUser(String userId);
    void removeUser(User user);
    void addCart(User user, Cart cart);
}

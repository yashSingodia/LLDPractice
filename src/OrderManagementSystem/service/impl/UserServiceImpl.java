package OrderManagementSystem.service.impl;

import OrderManagementSystem.model.Cart;
import OrderManagementSystem.model.User;
import OrderManagementSystem.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    private final List<User> userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(String userId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUser(User user) {
        userList.remove(user);
    }

    @Override
    public void addCart(User user, Cart cart) {
        for (User us : userList) {
            if (Objects.equals(us, user)) {
                user.setCartDetails(cart);
            }
        }
    }
}

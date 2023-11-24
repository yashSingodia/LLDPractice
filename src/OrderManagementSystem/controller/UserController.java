package OrderManagementSystem.controller;

import OrderManagementSystem.model.User;
import OrderManagementSystem.service.UserService;

import java.util.Objects;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void removeUser(User user) {
        userService.removeUser(user);
    }

    public User getUser(String userId) {
        User user = userService.getUser(userId);

        if (Objects.isNull(user)) {
            System.out.println("User is not found, returning null");
            return null;
        }

        return user;
    }
}

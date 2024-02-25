package FlashSale.main.java.repository;

import exceptions.UserNotFoundException;
import models.User;

import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class UserRepository {

    private final HashMap<String, User> usersMap;

    public UserRepository() {
        this.usersMap = new HashMap<>();
    }

    public void addUser(String userId, User user) {

        if (!usersMap.containsKey(userId)) {
            usersMap.put(userId, user);
        }

        System.out.println(String.format("User %s sucessfully added", userId));
    }

    public User getUser(String userId) throws UserNotFoundException {
        if (!usersMap.containsKey(userId)) {
            throw new UserNotFoundException(String.format("User %s not found", userId));
        }
        return usersMap.get(userId);
    }

    public void updateUserMap(String userId, User user) {
        usersMap.put(userId, user);
    }
}

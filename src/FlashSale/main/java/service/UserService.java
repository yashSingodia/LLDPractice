package FlashSale.main.java.service;

import exceptions.UserNotFoundException;
import models.User;
import repository.UserRepository;

import javax.inject.Singleton;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String userId, User user) {
        userRepository.addUser(userId, user);
    }

    public User getUser(String userId) throws UserNotFoundException {
        return userRepository.getUser(userId);
    }

    public boolean validateUserForDeal(String userId, String dealId) throws UserNotFoundException {
        User user = userRepository.getUser(userId);
        return user.getDealIds().isEmpty() || !user.getDealIds().contains(dealId);
    }

    public void addDealForUser(String userId, String dealId) throws UserNotFoundException {
        User user = userRepository.getUser(userId);
        user.getDealIds().add(dealId);
        userRepository.updateUserMap(userId, user);
    }
}

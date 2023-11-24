package EcommerceApplication.services;

import EcommerceApplication.exceptions.BuyerNotFoundException;
import EcommerceApplication.models.Buyer;

import java.util.List;

public interface BuyerService {
    Buyer addBuyer(Buyer buyer);

    Buyer getBuyer(String buyerId, String emailId, String password) throws BuyerNotFoundException;

    List<String> getOrderHistory(String buyerId);

    void addOrderInHistory(String buyerId, String orderId);
}

package Ecommerce.repository;

import Ecommerce.exceptions.BuyerNotFoundException;
import Ecommerce.exceptions.BuyerAlreadyPresentException;
import Ecommerce.models.Buyer;

import java.util.HashMap;

public class BuyerRepository {
    private HashMap<String, Buyer> buyersMap;

    public BuyerRepository() {
        this.buyersMap = new HashMap<>();
    }

    public Buyer addBuyer(Buyer buyer) {
        if (buyersMap.containsKey(buyer.getBuyerId())) {
            throw new BuyerAlreadyPresentException("Buyer is already Present");
        }
        buyersMap.put(buyer.getBuyerId(), buyer);
        return buyer;
    }

    public Buyer getBuyer(String buyerId) {
        if (buyersMap.containsKey(buyerId)) {
            return buyersMap.get(buyerId);
        } else {
            throw new BuyerNotFoundException("Buyer is not present");
        }
    }
}

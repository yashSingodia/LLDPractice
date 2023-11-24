package EcommerceApplication.repository;

import EcommerceApplication.exceptions.BuyerAlreadyPresentException;
import EcommerceApplication.exceptions.BuyerNotFoundException;
import EcommerceApplication.models.Buyer;

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
        System.out.println("Buyer added succesfully with name " + buyer.getBuyerName());
        buyersMap.put(buyer.getBuyerId(), buyer);
        return buyer;
    }

    public Buyer getBuyer(String buyerId) throws BuyerNotFoundException {
        if (buyersMap.containsKey(buyerId)) {
            return buyersMap.get(buyerId);
        } else {
            throw new BuyerNotFoundException("Buyer is not present in the system, Please sign-up");
        }
    }
}

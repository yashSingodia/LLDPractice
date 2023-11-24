package EcommerceApplication.services.impl;


import EcommerceApplication.exceptions.BuyerNotFoundException;
import EcommerceApplication.exceptions.InputValidationException;
import EcommerceApplication.models.Buyer;
import EcommerceApplication.repository.BuyerRepository;
import EcommerceApplication.services.AuthnService;
import EcommerceApplication.services.BuyerService;

import java.util.List;
import java.util.Objects;


public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final AuthnService authnService;
    public BuyerServiceImpl(BuyerRepository buyerRepository, AuthnService inputValidatorService) {
        this.buyerRepository = buyerRepository;
        this.authnService = inputValidatorService;
    }

    @Override
    public Buyer addBuyer(Buyer buyer) {
        if (authnService.authenticate(buyer)) {
            return buyerRepository.addBuyer(buyer);
        } else {
            throw new InputValidationException("Please enter the correct details");
        }
    }

    @Override
    public Buyer getBuyer(String buyerId, String emailId, String password) throws BuyerNotFoundException {
        // add logs
        // add metrics
        return buyerRepository.getBuyer(buyerId);
    }

    @Override
    public List<String> getOrderHistory(String buyerId) {
        Buyer buyer;
        try {
            buyer = buyerRepository.getBuyer(buyerId);
        } catch (BuyerNotFoundException e) {
            throw new RuntimeException("Buyer is not present");
        }

        List<String> orderList = buyer.getOrderIds();

        if (Objects.equals(orderList.size(), 0)) {
            System.out.println("No order found for this user");
        }

        return orderList;
    }

    @Override
    public void addOrderInHistory(String buyerId, String orderId) {
        Buyer buyer;
        try {
             buyer = buyerRepository.getBuyer(buyerId);
        } catch (BuyerNotFoundException e) {
            throw new RuntimeException(e);
        }
        buyer.getOrderIds().add(orderId);
    }
}

package Ecommerce.services.impl;


import Ecommerce.models.Buyer;
import Ecommerce.repository.BuyerRepository;
import Ecommerce.services.BuyerService;


public class BuyerServiceImpl implements BuyerService {

    BuyerRepository buyerRepository;
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer addBuyer(Buyer buyer) {
        return buyerRepository.addBuyer(buyer);
    }

    @Override
    public Buyer getBuyer(String buyerId) {
        // add logs
        // add metrics
        return buyerRepository.getBuyer(buyerId);
    }
}

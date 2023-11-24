package Ecommerce.services;

import Ecommerce.models.Buyer;

public interface BuyerService {
    Buyer addBuyer(Buyer buyer);

    Buyer getBuyer(String buyerId);
}

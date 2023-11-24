package EcommerceApplication.services.impl;

import EcommerceApplication.models.Buyer;
import EcommerceApplication.services.AuthnService;

public class AuthnServiceImpl implements AuthnService {
    @Override
    public boolean authenticate(Buyer buyer) {
        // Run all the validations for the input
        return true;
    }
}

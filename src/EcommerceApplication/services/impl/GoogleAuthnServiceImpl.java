package EcommerceApplication.services.impl;

import EcommerceApplication.models.Buyer;
import EcommerceApplication.services.AuthnService;

public class GoogleAuthnServiceImpl implements AuthnService {
    @Override
    public boolean authenticate(Buyer buyer) {
        return false;
    }
}

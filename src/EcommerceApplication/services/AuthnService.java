package EcommerceApplication.services;

import EcommerceApplication.models.Buyer;

public interface AuthnService {
    public boolean authenticate(Buyer buyer);
}

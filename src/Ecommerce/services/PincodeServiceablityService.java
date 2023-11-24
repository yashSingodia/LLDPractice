package Ecommerce.services;

import Ecommerce.models.PaymentMethod;

public interface PincodeServiceablityService {
    boolean createPincodeServiceabiltiy(String sourcePincode, String destinationPincode, PaymentMethod paymentMethod);

    boolean chcekIfSourceAndDestinationPincodeMatch(String sourceCode, String destinationPincode, PaymentMethod paymentMethod);
}

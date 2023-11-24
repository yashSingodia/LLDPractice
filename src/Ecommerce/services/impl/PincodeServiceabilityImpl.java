package Ecommerce.services.impl;

import Ecommerce.models.PaymentMethod;
import Ecommerce.models.PincodeServiceability;
import Ecommerce.repository.PincodeServiceablityRepository;
import Ecommerce.services.PincodeServiceablityService;

import java.util.HashMap;

public class PincodeServiceabilityImpl implements PincodeServiceablityService {
    PincodeServiceablityRepository pincodeServiceablityRepository;

    public PincodeServiceabilityImpl(PincodeServiceablityRepository pincodeServiceablityRepository) {
        this.pincodeServiceablityRepository = pincodeServiceablityRepository;
    }

    @Override
    public boolean createPincodeServiceabiltiy(String sourcePincode, String destinationPincode, PaymentMethod paymentMethod) {
        PincodeServiceability pincodeServiceability = new PincodeServiceability(destinationPincode, paymentMethod);
        return pincodeServiceablityRepository.createPincodeServiceability(sourcePincode, pincodeServiceability);
    }

    @Override
    public boolean chcekIfSourceAndDestinationPincodeMatch(String sourceCode, String destinationPincode, PaymentMethod paymentMethod) {
        HashMap<String, PaymentMethod> destinationPincodes = pincodeServiceablityRepository.getAllPincode(sourceCode);
        return destinationPincodes.containsKey(destinationPincode) && destinationPincodes.get(destinationPincode).equals(paymentMethod);
    }
}

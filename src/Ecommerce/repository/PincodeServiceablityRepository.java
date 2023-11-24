package Ecommerce.repository;

import Ecommerce.models.PaymentMethod;
import Ecommerce.models.PincodeServiceability;

import java.util.HashMap;
import java.util.Objects;

public class PincodeServiceablityRepository {
    private HashMap<String, HashMap<String, PaymentMethod>> pinCodes;

    public PincodeServiceablityRepository() {
        pinCodes = new HashMap<>();
    }

    public boolean createPincodeServiceability(String sourcePincode, PincodeServiceability pincodeServiceability) {
        if (Objects.isNull(pinCodes.get(sourcePincode))) {
            HashMap<String, PaymentMethod> destinatinoPincode = new HashMap();
            destinatinoPincode.put(pincodeServiceability.getDestinationPincode(), pincodeServiceability.getPaymentMethod());
            pinCodes.put(sourcePincode, destinatinoPincode);
        } else {
            pinCodes.get(sourcePincode).put(pincodeServiceability.getDestinationPincode(), pincodeServiceability.getPaymentMethod());
        }
        return true;
    }

    public HashMap<String, PaymentMethod> getAllPincode(String sourcePincode) {
        return pinCodes.get(sourcePincode);
    }
}

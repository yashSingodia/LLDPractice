package MicroProcessorSystem.service.impl;

import MicroProcessorSystem.model.Register;
import MicroProcessorSystem.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Register register) {
        return true;
    }
}

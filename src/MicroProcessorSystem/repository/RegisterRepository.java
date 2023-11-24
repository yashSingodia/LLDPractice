package MicroProcessorSystem.repository;

import MicroProcessorSystem.exceptions.ValidationFailedForRegisterException;
import MicroProcessorSystem.model.Register;
import MicroProcessorSystem.service.ValidationService;

public class RegisterRepository {

    private final ValidationService validationService;

    public RegisterRepository(ValidationService validationService) {
        this.validationService = validationService;
    }

    public boolean setValueInRegister(Register register, int value) {

        if (!validationService.validate(register)) {
            throw new ValidationFailedForRegisterException("");
        }

        register.setRegisterValue(value);
        return true;

    }

    public boolean incrementRegisterValue(Register register) {

        if (!validationService.validate(register)) {
            throw new ValidationFailedForRegisterException("");
        }

        register.setRegisterValue(register.getRegisterValue() + 1);
        return true;
    }

    public boolean decrementRegisterValue(Register register) {

        if (!validationService.validate(register)) {
            throw new ValidationFailedForRegisterException("");
        }

        register.setRegisterValue(register.getRegisterValue() - 1);
        return true;
    }

    public boolean moveRegisterValue(Register register, Register registerToBeCopied) {

        if (!validationService.validate(register) || !validationService.validate(registerToBeCopied)) {
            throw new ValidationFailedForRegisterException("");
        }

        register.setRegisterValue(registerToBeCopied.getRegisterValue());
        return true;
    }

    public boolean addRegisterValuesInFistRegister(Register register, Register registerToBeCopied) {

        if (!validationService.validate(register) || !validationService.validate(registerToBeCopied)) {
            throw new ValidationFailedForRegisterException("");
        }

        register.setRegisterValue(registerToBeCopied.getRegisterValue() + registerToBeCopied.getRegisterValue());
        return true;
    }
}

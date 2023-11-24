package MicroProcessorSystem.service;

import MicroProcessorSystem.model.Register;

public interface RegisterService {
    boolean setValueInRegister(Register register, int value);

    boolean incrementRegisterValue(Register register);

    boolean moveRegisterValue(Register register, Register toBeCopiedRegister);

    boolean decrementRegisterValue(Register register);

    boolean addRegisterValuesInFistRegister(Register register, Register anotherRegister);

    void getValueInRegister(Register register);
}

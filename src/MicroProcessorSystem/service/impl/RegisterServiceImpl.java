package MicroProcessorSystem.service.impl;

import MicroProcessorSystem.model.Register;
import MicroProcessorSystem.repository.RegisterRepository;
import MicroProcessorSystem.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public boolean setValueInRegister(Register register, int value) {
        return registerRepository.setValueInRegister(register, value);
    }

    @Override
    public boolean incrementRegisterValue(Register register) {
        return registerRepository.incrementRegisterValue(register);
    }

    @Override
    public boolean moveRegisterValue(Register register, Register toBeCopiedRegister) {
        return registerRepository.moveRegisterValue(register, toBeCopiedRegister);
    }

    @Override
    public boolean decrementRegisterValue(Register register) {
        return registerRepository.decrementRegisterValue(register);
    }

    @Override
    public boolean addRegisterValuesInFistRegister(Register register, Register anotherRegister) {
        return registerRepository.addRegisterValuesInFistRegister(register, anotherRegister);
    }

    @Override
    public void getValueInRegister(Register register) {
        System.out.println(register);
    }
}

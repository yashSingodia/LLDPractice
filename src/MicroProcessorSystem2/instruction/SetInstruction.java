package MicroProcessorSystem2.instruction;

import MicroProcessorSystem2.model.Register;
import MicroProcessorSystem2.repository.RegisterRepository;

public class SetInstruction implements Instruction {
    private final RegisterRepository registerRepository;
    private final String register;
    private final int value;

    public SetInstruction(RegisterRepository registerRepository, String register, int value) {
        this.registerRepository = registerRepository;
        this.register = register;
        this.value = value;
    }
    @Override
    public void executeInstruction() {
        Register createdRegister = registerRepository.getRegister(register);
        createdRegister.setRegisterValue(value);
    }
}

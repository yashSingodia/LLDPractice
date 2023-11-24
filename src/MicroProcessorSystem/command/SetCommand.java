package MicroProcessorSystem.command;

import MicroProcessorSystem.factory.RegisterFactory;
import MicroProcessorSystem.factory.RegisterType;
import MicroProcessorSystem.model.Register;
import MicroProcessorSystem.service.RegisterService;
import MicroProcessorSystem.service.impl.RegisterServiceImpl;

public class SetCommand implements Command{

    private final String register;
    private final int value;
    private final RegisterService registerService;
    public SetCommand(String register, int value, RegisterService registerService) {
        this.register = register;
        this.value = value;
        this.registerService = registerService;
    }

    @Override
    public void execute() {
        System.out.println("Performing SET command on register");
        RegisterType registerType = RegisterType.valueOf(register);
        Register registerProcessor = RegisterFactory.getRegister(registerType);
        registerService.setValueInRegister(registerProcessor, value);
        registerService.getValueInRegister(registerProcessor);
    }
}

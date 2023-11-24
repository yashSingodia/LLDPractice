package MicroProcessorSystem2.service.impl;

import MicroProcessorSystem2.instruction.Instruction;
import MicroProcessorSystem2.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    @Override
    public void performExecution(Instruction instruction) {
        instruction.executeInstruction();
    }
}

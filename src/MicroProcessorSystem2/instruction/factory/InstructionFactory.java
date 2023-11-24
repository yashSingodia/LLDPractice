package MicroProcessorSystem2.instruction.factory;

import MicroProcessorSystem2.instruction.Instruction;
import MicroProcessorSystem2.instruction.SetInstruction;
import MicroProcessorSystem2.repository.RegisterRepository;

public class InstructionFactory {

    public static Instruction getSetInstruction(RegisterRepository registerRepository, String register, int value) {
        return new SetInstruction(registerRepository, register, value);
    }

    public static Instruction getAddInstruction(RegisterRepository registerRepository, String register, int value) {
        return null;
    }
}

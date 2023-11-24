package MicroProcessorSystem2.service;

import MicroProcessorSystem2.instruction.Instruction;

public interface RegisterService {
    void performExecution(Instruction instruction);
}

package MicroProcessorSystem2;


import MicroProcessorSystem2.instruction.Instruction;
import MicroProcessorSystem2.instruction.factory.InstructionFactory;
import MicroProcessorSystem2.repository.RegisterRepository;
import MicroProcessorSystem2.service.RegisterService;
import MicroProcessorSystem2.service.impl.RegisterServiceImpl;

import java.util.Objects;
import java.util.Scanner;

public class RegisterApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command for the registers -- ");
//        ValidationService validationService = new ValidationServiceImpl();
        RegisterRepository registerRepository = new RegisterRepository();
        RegisterService registerService = new RegisterServiceImpl();

        registerRepository.addRegister("A");
        registerRepository.addRegister("B");
        registerRepository.addRegister("C");
        registerRepository.addRegister("D");

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lineSplit = line.split("\\s+");
            String command = lineSplit[0];
            String firstRegister = lineSplit[1];
            String secondValue = lineSplit[2];

            if (Objects.equals(command, "SET")) {

                int value = Integer.parseInt(secondValue);
                Instruction instruction = InstructionFactory.getSetInstruction(registerRepository, firstRegister, value);
                registerService.performExecution(instruction);

                registerRepository.printAllRegister();

            } else if (Objects.equals(command, "MOVE")) {


            }

        }
    }
}

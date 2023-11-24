package MicroProcessorSystem;



import MicroProcessorSystem.command.Command;
import MicroProcessorSystem.command.SetCommand;
import MicroProcessorSystem.repository.RegisterRepository;
import MicroProcessorSystem.service.RegisterService;
import MicroProcessorSystem.service.ValidationService;
import MicroProcessorSystem.service.impl.RegisterServiceImpl;
import MicroProcessorSystem.service.impl.ValidationServiceImpl;

import java.util.Objects;
import java.util.Scanner;

public class RegisterApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command for the registers -- ");
        ValidationService validationService = new ValidationServiceImpl();
        RegisterRepository registerRepository = new RegisterRepository(validationService);
        RegisterService registerService = new RegisterServiceImpl(registerRepository);

        Command commandPattern = null;

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lineSplit = line.split("\\s+");
            String command = lineSplit[0];
            String firstRegister = lineSplit[1];
            String secondValue = lineSplit[2];

            if (Objects.equals(command, "SET")) {

                int value = Integer.parseInt(secondValue);
                commandPattern = new SetCommand(firstRegister, value, registerService);


            } else if (Objects.equals(command, "MOVE")) {


            }
            commandPattern.execute();

        }
    }
}

package MicroProcessorSystem2.repository;

import MicroProcessorSystem2.exceptions.RegisterNotFoundException;
import MicroProcessorSystem2.model.Register;
import MicroProcessorSystem2.model.RegisterType;

import java.util.HashMap;
import java.util.Map;

public class RegisterRepository {
    private final Map<RegisterType, Register> registerMap;

    public RegisterRepository() {
        this.registerMap = new HashMap<>();
    }

    public Register getRegister(String register) {
        RegisterType registerType = RegisterType.valueOf(register);

        if (registerMap.containsKey(registerType)) {
            return registerMap.get(registerType);
        } else {
            throw new RegisterNotFoundException("");
        }
    }

    public void addRegister(String register) {
        RegisterType registerType = RegisterType.valueOf(register);
        registerMap.put(registerType, new Register());
    }

    public void removeRegister(String register) {
        RegisterType registerType = RegisterType.valueOf(register);
        registerMap.remove(registerType);
    }

    public void printAllRegister() {
        System.out.println(registerMap);
    }
}

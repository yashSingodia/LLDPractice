package MicroProcessorSystem.factory;

import MicroProcessorSystem.exceptions.UnknownRegisterTypeException;
import MicroProcessorSystem.model.Register;
import MicroProcessorSystem.model.impl.RegisterA;
import MicroProcessorSystem.model.impl.RegisterB;
import MicroProcessorSystem.model.impl.RegisterC;
import MicroProcessorSystem.model.impl.RegisterD;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterFactory {

    private static final Map<RegisterType, Register> registerTypeRegisterMap = new HashMap<>();
    private static RegisterFactory registerFactory;
    private RegisterFactory() {}

    public static RegisterFactory getRegisterFactory() {
        if (Objects.isNull(registerFactory)) {
            registerFactory = new RegisterFactory();
        }
        return registerFactory;
    }

    public static Register getRegister(RegisterType registerType) {
        if (registerTypeRegisterMap.containsKey(registerType)) {
            return registerTypeRegisterMap.get(registerType);
        } else {
            Register register = createRegisterObject(registerType);
            registerTypeRegisterMap.put(registerType, register);
            return register;
        }
    }

    public static Register createRegisterObject(RegisterType registerType) {
        switch (registerType) {
            case A:
                return new RegisterA();
            case B:
                return new RegisterB();
            case C:
                return new RegisterC();
            case D:
                return new RegisterD();
            default:
                throw new UnknownRegisterTypeException("Please pass the correct register type");
        }
    }

    public static Map<RegisterType, Register> getRegisterMap() {
        return registerTypeRegisterMap;
    }
}

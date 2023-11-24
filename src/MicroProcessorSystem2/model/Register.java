package MicroProcessorSystem2.model;

public class Register {
    private int registerValue;

    public Register() {
        this.registerValue = 0;
    }
    public void setRegisterValue(int registerValue) {
        this.registerValue = registerValue;
    }
    public int getRegisterValue() {
        return registerValue;
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerValue=" + registerValue +
                '}';
    }
}

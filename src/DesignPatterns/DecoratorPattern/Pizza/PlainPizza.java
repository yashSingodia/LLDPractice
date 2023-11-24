package DesignPatterns.DecoratorPattern.Pizza;

public class PlainPizza extends Pizza{
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public int getCost() {
        return 10;
    }
}

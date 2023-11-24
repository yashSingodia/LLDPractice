package DesignPatterns.DecoratorPattern.Pizza;

public class MargheritaPizza extends Pizza{

    @Override
    public String getDescription() {
        return "Margherita Piza ";
    }

    @Override
    public int getCost() {
        return 15;
    }
}

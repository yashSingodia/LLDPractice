package DesignPatterns.DecoratorPattern.Burger;

public class CheeseBurger extends Burger {
    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Cheese Burger";
    }
}

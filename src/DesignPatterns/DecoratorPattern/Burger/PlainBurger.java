package DesignPatterns.DecoratorPattern.Burger;

public class PlainBurger extends Burger {
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Plain Burger";
    }
}

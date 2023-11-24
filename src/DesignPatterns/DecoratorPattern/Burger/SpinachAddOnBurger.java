package DesignPatterns.DecoratorPattern.Burger;

public class SpinachAddOnBurger extends DecoratorAddOn {
    Burger burger;

    public SpinachAddOnBurger(Burger burger) {
        this.burger = burger;
    }

    @Override
    public int getCost() {
        return this.burger.getCost() + 100;
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + " :Spinach AddOn";
    }
}

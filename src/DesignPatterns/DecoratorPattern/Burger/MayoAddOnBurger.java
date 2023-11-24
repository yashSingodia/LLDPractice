package DesignPatterns.DecoratorPattern.Burger;

public class MayoAddOnBurger extends  DecoratorAddOn{
    Burger burger;

    public MayoAddOnBurger(Burger burger) {
        this.burger = burger;
    }

    @Override
    public int getCost() {
        return this.burger.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + " : Mayo burger";
    }
}

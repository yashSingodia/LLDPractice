package DesignPatterns.DecoratorPattern.Pizza;

public class MushroomDecorator extends DecoratorPizza {
    Pizza pizza;

    public MushroomDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " Mushroom Decorator ";
    }

    @Override
    public int getCost() {
        return this.pizza.getCost() + 30;
    }
}

package DesignPatterns.DecoratorPattern.Pizza;

public class ExtraCheeseDecorator extends DecoratorPizza {

    Pizza pizza;

    public ExtraCheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " Extra Cheese Decorator";
    }

    @Override
    public int getCost() {
        return this.pizza.getCost() + 20;
    }
}

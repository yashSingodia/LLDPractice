package DesignPatterns.DecoratorPattern.Pizza;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = new MushroomDecorator(new MargheritaPizza());
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("cost " + pizza.getCost());

    }
}

package DesignPatterns.DecoratorPattern.Burger;

public class Main {

    public static void main(String[] args) {
        Burger cutaBurger = new MayoAddOnBurger(new SpinachAddOnBurger(new PlainBurger()));
        System.out.println("Desc " + cutaBurger.getDescription());
        System.out.println("cost " + cutaBurger.getCost());
    }
}

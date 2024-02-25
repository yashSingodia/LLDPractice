package LLDAmazon.SnakesAndLadders.implementation;

import LLDAmazon.SnakesAndLadders.models.Dice;

import java.util.Random;

public class NormalDice implements Dice {

    @Override
    public Integer rollDice(int maxNumber) {
        Integer rollNumber = new Random().nextInt(maxNumber) + 1;
        return rollNumber;
    }
}

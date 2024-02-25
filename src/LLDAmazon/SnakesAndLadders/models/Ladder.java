package LLDAmazon.SnakesAndLadders.models;

import LLDAmazon.SnakesAndLadders.exceptions.InvalidSnakePositionException;

public class Ladder extends Jumper {
    protected Ladder(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public void validationPositionOrThrowException(int position) {
        if (position >= nextPosition) {
            throw new InvalidSnakePositionException("");
        }
    }
}

package LLDAmazon.SnakesAndLadders.models;

import LLDAmazon.SnakesAndLadders.exceptions.InvalidSnakePositionException;

public class Snake extends Jumper {

    protected Snake(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public void validationPositionOrThrowException(int position) {
        if (position <= nextPosition) {
            throw new InvalidSnakePositionException("");
        }
    }
}

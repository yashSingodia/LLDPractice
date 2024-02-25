package LLDAmazon.SnakesAndLadders.models;

public abstract class Jumper {
    public final int nextPosition;

    protected Jumper(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public abstract void validationPositionOrThrowException(int position);
}

package LLDAmazon.SnakesAndLadders.models;

import java.util.Optional;

public class Cell {

    private final int position;
    private final Jumper jumper;

    public Cell(int position, Jumper jumper) {
        this.position = position;
        this.jumper = jumper;
        Optional.of(this.jumper).ifPresent(jum -> jum.validationPositionOrThrowException(position));
    }

    public int getPosition() {
        return position;
    }

    public int getNextPosition() {
        return Optional.ofNullable(jumper).map(Jumper::getNextPosition).orElse(this.position);
    }
}

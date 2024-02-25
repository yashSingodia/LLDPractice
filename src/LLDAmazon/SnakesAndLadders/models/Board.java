package LLDAmazon.SnakesAndLadders.models;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Board {
    private HashMap<Integer, Cell> cellsMap;
    private int length;
    private int breadth;

    public Board(int length, int breadth, Cell[] cells) {
        cellsMap = new HashMap<>();

        Arrays.stream(cells).forEach(cell -> {
            cellsMap.put(cell.getPosition(), cell);
        });
        this.length = length;
        this.breadth = breadth;
    }

    public int getNextPosition(int curPosition, int steps) {
        int nextPosition = curPosition + steps;
        if(nextPosition >= length * breadth) {
            return length * breadth;
        }
        return Optional.ofNullable(this.cellsMap.get(nextPosition)).map(
                Cell::getNextPosition
        ).orElse(nextPosition);

    }

    public boolean reachedEnd(int position) {
        return position == length*breadth;
    }
}

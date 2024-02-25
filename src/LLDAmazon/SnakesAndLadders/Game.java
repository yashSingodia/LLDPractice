package LLDAmazon.SnakesAndLadders;

import LLDAmazon.SnakesAndLadders.models.Board;
import LLDAmazon.SnakesAndLadders.models.Cell;
import LLDAmazon.SnakesAndLadders.models.Player;
import LLDAmazon.SnakesAndLadders.service.PlayerService;

import java.util.stream.IntStream;

public class Game {
    private final Player[] players = new Player[2];
    private final PlayerService playerService;
    private final Board board;
    private final GameStatus gameStatus;
    private int nextPlayerIndex = 0;

    public Game(PlayerService playerService, int length, int breadth, Player[] players, Cell[] cells) {

        this.board = new Board(length, breadth, cells);
        IntStream.range(0, players.length).forEach(i -> this.players[i] = players[i]);
        this.playerService = playerService;
        gameStatus = GameStatus.STARTED;
    }

    public void play(Player player) {
        // validations
        if (GameStatus.FINISHED.equals(gameStatus)) {
            throw new RuntimeException();
        }

        // roll dice
        // nextPos
        // check if winner
        // nextPlayerIndex =( nextPlayerIndex + 1) % players.length

    }
}

package TicTacToe.model;

import TicTacToe.utils.Utils;

public class Player {
    private final String id;
    private final String name;

    private final Piece piece;

    public Player(String name, Piece piece) {
        this.id = Utils.generateRandomUUID();
        this.name = name;
        this.piece = piece;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
}

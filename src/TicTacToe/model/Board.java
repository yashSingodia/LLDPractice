package TicTacToe.model;

import java.util.Objects;

public class Board {
    private final int size;

    private Piece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public boolean addPiece(int row, int col, Piece piece) {
        if (Objects.isNull(board[row][col])) {
            board[row][col] = piece;
            return true;
        } else {
            return false;
        }
    }

    public void printBoard() {
        System.out.println("Printing Board ---");
        for (int rows = 0; rows < this.size; rows++) {
            for (int cols = 0; cols < this.size; cols++) {
                System.out.print((board[rows][cols] == null ? "_" : board[rows][cols].getPieceType().name()) + " ");
            }
            System.out.println();
        }
    }

    public boolean isAvailable(int row, int col) {
        return Objects.isNull(board[row][col]);
    }

    public boolean checkIfAnyoneIsWinner(Piece piece) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < size; i++) {
            if (board[i][0] == null || board[i][0] != piece) {
                rowMatch = false;
            }
        }

        for (int i = 0; i < size; i++) {
            if (board[0][i] == null || board[0][i] != piece) {
                colMatch = false;
            }
        }

        for (int i = 0; i < size; i++) {
            if (board[i][i] == null || board[i][i] != piece) {
                diagonalMatch = false;
            }
        }

        for (int i = 0, j = size - 1; i < size; j--, i++) {
            if (board[i][j] == null || board[i][j] != piece) {
                antiDiagonalMatch = false;
            }

        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }

    public boolean isEmpty() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (Objects.isNull(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }
}

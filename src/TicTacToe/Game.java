package TicTacToe;

import TicTacToe.model.Board;
import TicTacToe.model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    private Deque<Player> players;
    private Board board;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();

        Player p1 = new Player("Yash", new PieceTypeO());
        Player p2 = new Player("ABCD", new PieceTypeX());

        players.add(p1);
        players.add(p2);

        board = new Board(3);
    }

    public void startGame() {
        boolean noWinner = true;
        while (noWinner) {

            Player player = players.removeFirst();
            board.printBoard();

            if (board.isEmpty()) {
                System.out.println("Game tied.");
                noWinner = false;
                continue;
            }

            System.out.println("Player turn " + player.getName());
            System.out.println("Enter the row and column for player " + player.getName() + " ");

            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            String[] values = s.split(",");

            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            if (board.isAvailable(row, col)) {
                if (board.addPiece(row, col, player.getPiece())) {
                    System.out.println("Adding piece to the position..");
                } else {
                    System.out.println("Piece is not added to the position..");
                }
                players.addLast(player);
            } else {
                System.out.println("This position is already occupied, Please try again ");
                players.addFirst(player);
                continue;
            }

            if (board.checkIfAnyoneIsWinner(player.getPiece())) {
                System.out.println("Winner of the game is: " + player.getName());
                noWinner = false;
            }
        }
        board.printBoard();
    }


}

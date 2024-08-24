package tictactoe;

import interfaces.Board;
import interfaces.BoardGame;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import model.Player;

public class TicTacToeGame implements BoardGame {
    List<Player> ticTacToePlayers;
    Board ticTacToeBoard;

    public TicTacToeGame() {
        this.ticTacToePlayers = new ArrayList<>();
        this.ticTacToeBoard = new TicTacToeBoard(squareBoardSize());
    }

    @Override
    public int squareBoardSize() {
        return 3;
    }

    @Override
    public void addPlayer(Player player) {
        this.ticTacToePlayers.add(player);
    }

    @Override
    public void startGame() {
        System.out.println("----TIC TAC TOE Game has been started------");
        Deque<Player> playerTurnQueue = new ArrayDeque<>();

        // Addition of all players into the Deque
        ticTacToePlayers.forEach(playerTurnQueue::addLast);

        // Game has started and waiting for winner or tie
        while (true) {
            // Getting next player from Deque
            Player currPlayerTurn = playerTurnQueue.getLast();
            playerTurnQueue.removeLast();
            System.out.println("--- Player's turn : " + currPlayerTurn.getName() + ". Play your move in the format (x,y) : ");

            // Getting next move from the player
            Scanner scanner = new Scanner(System.in);
            String nextChance = scanner.nextLine();
            String[] playerMove = nextChance.split(",");
            int rowMove = Integer.parseInt(playerMove[0].trim());
            int colMove = Integer.parseInt(playerMove[1].trim());

            // Check whether possible move can be made or not
            if (!ticTacToeBoard.checkForValidMove(rowMove, colMove, currPlayerTurn)) {
                System.out.printf("--- Invalid move : %s, %s in tic tac toe board game by player : %s . Please try again !\n",
                        rowMove, colMove, currPlayerTurn.getName());
                playerTurnQueue.addLast(currPlayerTurn);
                continue;
            }

            // Updating board with the current player's move
            ticTacToeBoard.makeMove(rowMove, colMove, currPlayerTurn);

            // Show the board
            ticTacToeBoard.printBoard();

            // Tie condition
            if (ticTacToeBoard.checkTieCondition()) {
                System.out.println("---Game has been TIED---");
                return;
            }

            // Winner condition
            if (ticTacToeBoard.checkWinningCondition()) {
                System.out.printf("---Tic tac toe has been WON by %s---\n", currPlayerTurn.getName());
                return;
            }

            // Addition of curr player to the Deque
            playerTurnQueue.addFirst(currPlayerTurn);
        }
    }
}

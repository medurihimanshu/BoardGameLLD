package interfaces;

import model.Player;

public interface Board {

    boolean checkWinningCondition();

    boolean checkTieCondition();

    boolean checkForValidMove(int rowMove, int columnMove, Player player);

    void makeMove(int rowMove, int columnMove, Player player);

    void printBoard();

}

package tictactoe;

import interfaces.Board;
import java.util.Objects;
import model.Player;
import model.PlayerPieceChoice;

public class TicTacToeBoard implements Board {
    PlayerPieceChoice[][] board;

    public TicTacToeBoard(int size) {
        this.board = new PlayerPieceChoice[size][size];
    }

    @Override
    public boolean checkWinningCondition() {
        for (int i = 0; i < board.length; i++) {
            boolean rowWin = true;
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j-1] != board[i][j] || Objects.isNull(board[i][j])) {
                    rowWin = false;
                }
            }
            if (rowWin)
                return true;
        }
        return false;
    }

    @Override
    public boolean checkTieCondition() {
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (Objects.isNull(board[i][j]))
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkForValidMove(int rowMove, int columnMove, Player player) {
        return (rowMove < board.length) && (columnMove < board[0].length)
                && (Objects.isNull(board[rowMove][columnMove]));
    }

    @Override
    public void makeMove(int rowMove, int columnMove, Player player) {
        board[rowMove][columnMove] = player.getPlayerPieceChoice();
    }

    @Override
    public void printBoard() {
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.printf("| %s ", board[i][j]);
            }
            System.out.println();
        }
    }

}

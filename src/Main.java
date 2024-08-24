import model.Player;
import tictactoe.TicTacToeGame;
import tictactoe.model.TicTacToePieceO;
import tictactoe.model.TicTacToePieceX;

public class Main {
    public static void main(String[] args) {
        playTicTacToe();
    }

    private static void playTicTacToe() {
        Player himanshu = new Player("Himanshu", new TicTacToePieceO());
        Player mansi = new Player("Mansi", new TicTacToePieceX());

        TicTacToeGame game = new TicTacToeGame();
        game.addPlayer(himanshu);
        game.addPlayer(mansi);
        game.startGame();
    }
}
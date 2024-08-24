package interfaces;

import model.Player;

public interface BoardGame {
    int squareBoardSize();
    void addPlayer(Player player);
    void startGame();
}

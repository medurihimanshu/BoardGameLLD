package model;

public class Player {
    private final String name;
    private final PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public PlayerPieceChoice getPlayerPieceChoice() {
        return playingPiece.type;
    }
}

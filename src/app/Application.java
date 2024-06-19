package app;

import chess.ChessMatch;
import ui.UI;

public class Application {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

    }
}

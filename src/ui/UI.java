package ui;

import chess.ChessPiece;
import chess.Color;

public class UI {

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i=0; i <pieces.length;i++) {
            System.out.print((8-i) + "\t");
            for (int j=0; j<pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("\ta b c d e f g h");
    }

    private static void printPiece(ChessPiece piece){
        if (piece == null) {
            System.out.print("-");
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(UIColors.ANSI_BLUE + piece + UIColors.ANSI_RESET);
            } else {
                System.out.print(UIColors.ANSI_YELLOW + piece + UIColors.ANSI_RESET);

            }
        }
        System.out.print(" ");
    }
}

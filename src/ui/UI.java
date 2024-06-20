package ui;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

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

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }
}

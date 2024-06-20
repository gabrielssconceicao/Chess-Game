package ui;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void printBoard(ChessPiece[][] pieces) {
        for (int i=0; i <pieces.length;i++) {
            System.out.print((8-i) + "\t");
            for (int j=0; j<pieces.length; j++) {
                printPiece(pieces[i][j],false);
            }
            System.out.println();
        }
        System.out.println("\ta b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
            for (int i=0; i <pieces.length;i++) {
                System.out.print((8-i) + "\t");
                for (int j=0; j<pieces.length; j++) {
                    printPiece(pieces[i][j],possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("\ta b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background){
        if(background) {
            System.out.print(UIColors.ANSI_WHITE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-"+ UIColors.ANSI_RESET);
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

    public static void printMatch(ChessMatch chessMatch,List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());
        System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
        printCapturedPieces(captured);
    }

    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> white = captured.stream().filter(piece -> piece.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(piece -> piece.getColor() == Color.BLACK).collect(Collectors.toList());

        System.out.println("Captured Pieces: ");
        System.out.print("White: ");
        System.out.print(UIColors.ANSI_BLUE);
        System.out.print(Arrays.toString(white.toArray()));
        System.out.println(UIColors.ANSI_RESET);
        System.out.print("Black: ");
        System.out.print(UIColors.ANSI_YELLOW);
        System.out.print(Arrays.toString(black.toArray()));
        System.out.println(UIColors.ANSI_RESET);
    }
}

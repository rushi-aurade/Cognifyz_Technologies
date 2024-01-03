package Level2;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        int round = 1;

        while (true) {
            displayBoard(board);
            System.out.println("Round " + round);
            System.out.println("Player 1 (X), enter your move: ");
            String move1 = scanner.nextLine();
            int x1 = move1.charAt(0) - 'a';
            int y1 = move1.charAt(1) - '1';
            if (board[x1][y1] != '\u0000') {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            board[x1][y1] = 'X';

            if (checkWin(board, 'X')) {
                displayBoard(board);
                System.out.println("Player 1 (X) wins!");
                break;
            }

            if (checkDraw(board)) {
                displayBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            displayBoard(board);
            System.out.println("Player 2 (O), enter your move: ");
            String move2 = scanner.nextLine();
            int x2 = move2.charAt(0) - 'a';
            int y2 = move2.charAt(1) - '1';
            if (board[x2][y2] != '\u0000') {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            board[x2][y2] = 'O';

            if (checkWin(board, 'O')) {
                displayBoard(board);
                System.out.println("Player 2 (O) wins!");
                break;
            }

            if (checkDraw(board)) {
                displayBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            round++;
        }
    }

    private static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }
}

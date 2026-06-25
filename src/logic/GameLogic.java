package logic;

import java.util.Random;

public class GameLogic {

    private char[] board;

    public GameLogic() {
        board = new char[9];
        resetBoard();
    }

    public void resetBoard() {

        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    public boolean makeMove(int position, char symbol) {

        if (position < 0 || position > 8) {
            return false;
        }

        if (board[position] != ' ') {
            return false;
        }

        board[position] = symbol;
        return true;
    }

    public boolean checkWinner(char symbol) {

        int[][] winPatterns = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] pattern : winPatterns) {

            if (board[pattern[0]] == symbol &&
                    board[pattern[1]] == symbol &&
                    board[pattern[2]] == symbol) {

                return true;
            }
        }

        return false;
    }

    public boolean isDraw() {

        for (char cell : board) {

            if (cell == ' ') {
                return false;
            }
        }

        return true;
    }

    public int computerMove() {

        Random random = new Random();

        while (true) {

            int position = random.nextInt(9);

            if (board[position] == ' ') {

                board[position] = 'O';

                return position;
            }
        }
    }

    public char[] getBoard() {
        return board;
    }
}
package game1.tictactoe;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class TicTacToe {
    
    private String[] board;
    private boolean player1_turn;

    public TicTacToe() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = "";
        }
        firstTurn();
    }

    public void firstTurn() {
        player1_turn = new Random().nextInt(2) == 0;
    }

    public String makeMove(int index) {
        if (board[index].equals("")) {
            board[index] = player1_turn ? "X" : "O";
            player1_turn = !player1_turn;
            return checkWin();
        }
        return "Invalid move";
    }

    private String checkWin() {
        int[][] winPatterns = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };
    
        for (int[] pattern : winPatterns) {
            if (board[pattern[0]].equals("X") && board[pattern[1]].equals("X") && board[pattern[2]].equals("X")) {
                return "X Wins!-" + pattern[0] + "," + pattern[1] + "," + pattern[2];
            }
            if (board[pattern[0]].equals("O") && board[pattern[1]].equals("O") && board[pattern[2]].equals("O")) {
                return "O Wins!-" + pattern[0] + "," + pattern[1] + "," + pattern[2];
            }
        }
    
        for (String cell : board) {
            if (cell.equals("")) {
                return "Next move";
            }
        }
    
        return "It's a draw!";
    }

    public String getCurrentPlayer() {
        return player1_turn ? "X" : "O";
    }

    public String[] getBoard() {
        return board;
    }
}
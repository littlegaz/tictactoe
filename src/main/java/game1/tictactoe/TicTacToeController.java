package game1.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tictactoe")
public class TicTacToeController {

    @Autowired
    private TicTacToe ticTacToe;

    @GetMapping("/board")
    public String[] getBoard() {
        return ticTacToe.getBoard();
    }

    @GetMapping("/currentPlayer")
    public String getCurrentPlayer() {
        return ticTacToe.getCurrentPlayer();
    }

    @PostMapping("/move/{index}")
    public String makeMove(@PathVariable int index) {
        return ticTacToe.makeMove(index);
    }

    @PostMapping("/reset")
    public void resetGame() {
        ticTacToe = new TicTacToe();
    }

    // Add a test endpoint
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot is running!";
    }

}
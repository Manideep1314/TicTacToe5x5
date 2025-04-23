import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static final int SIZE = 5;
    private Button[][] buttons = new Button[SIZE][SIZE];
    private boolean xTurn = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Button btn = new Button("");
                btn.setMinSize(60, 60);
                int r = row, c = col;
                btn.setOnAction(e -> handleMove(btn, r, c));
                buttons[row][col] = btn;
                grid.add(btn, col, row);
            }
        }

        Scene scene = new Scene(grid, 320, 320);
        primaryStage.setTitle("Tic Tac Toe 5x5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMove(Button btn, int row, int col) {
        if (!btn.getText().isEmpty()) return;

        btn.setText(xTurn ? "X" : "O");
        xTurn = !xTurn;

        if (checkWinner(row, col)) {
            System.out.println((xTurn ? "O" : "X") + " wins!");
            disableAllButtons();
        }
    }

    private boolean checkWinner(int row, int col) {
        String symbol = buttons[row][col].getText();
        return checkLine(row, 0, 0, 1, symbol) || // horizontal
               checkLine(0, col, 1, 0, symbol) || // vertical
               checkLine(0, 0, 1, 1, symbol) ||    // diagonal
               checkLine(0, SIZE - 1, 1, -1, symbol); // anti-diagonal
    }

    private boolean checkLine(int startRow, int startCol, int rowInc, int colInc, String symbol) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            int r = startRow + i * rowInc;
            int c = startCol + i * colInc;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && buttons[r][c].getText().equals(symbol)) {
                count++;
                if (count == 5) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private void disableAllButtons() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                buttons[r][c].setDisable(true);
            }
        }
    }
}

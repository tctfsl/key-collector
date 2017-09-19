import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
  private static GameBoard gameBoard = new GameBoard();
  private Cell[][] bttn = new Cell[9][9];
  
  private GameBoard() {
  }
  
  public static GameBoard getGameBoard() {
    return gameBoard;
  }
  
  public void createGameBoard() {
    setPreferredSize(new Dimension(500, 500));
    setLayout(new GridLayout(9, 9));
    
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j] = new Cell(i, j);
        add(bttn[i][j]);
      }
    }
  }
}
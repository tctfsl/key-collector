import javax.swing.*;
import java.awt.*;

public class KeyCollector extends JFrame {
  private GameBoard gameBoard;
  private InfoBoard infoBoard;
  private PlayerPerson[] players = new PlayerPerson[4];
  
  public static void main(String[] arg) {
		new KeyCollector();
	}
	
	public KeyCollector() {
    super("Key Collector Game (JGroup)");
    //setSize(1000, 500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new GridLayout(1, 1));
    
    gameBoard = GameBoard.getGameBoard();
    gameBoard.createGameBoard();
    
    infoBoard = InfoBoard.getInfoBoard();
    infoBoard.createInfoBoard();
    
    add(gameBoard);
    add(infoBoard);
    
    pack();
    setVisible(true);
    
  }
}
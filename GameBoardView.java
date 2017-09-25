import javax.swing.JPanel;				//To implement the use of the JPanel
import java.awt.Color;					//To change the color of the background of the button
import java.awt.GridLayout;				//To set the layout of the GameBoardView panel
import java.awt.event.ActionListener;	//To implement the use of ActionListeners on the buttons
import java.util.Vector;				//To implement the use of Vectors to store the player's possible moves

/**
 * @author Megat, Miguel, Faisal;
 */

public class GameBoardView extends JPanel {
  //The buttons for the game
  private Cell[][] bttn;
  //Array of piece to store the players
  private Piece[] thePlayers = new Piece[4];
  
  //Instantiate the keys from the PieceFactory
  private Piece monkey = PieceFactory.getPiece("monkey");
  private Piece donkey = PieceFactory.getPiece("donkey");
  private Piece keydisk = PieceFactory.getPiece("keydisk");
  private Piece pinkey = PieceFactory.getPiece("pinkey");
  private Piece keynote = PieceFactory.getPiece("keynote");
  private Piece chest = PieceFactory.getPiece("chest");
  
  //GameBoardView constructor
  public GameBoardView() {
    setLayout(new GridLayout(9, 9));
    
    bttn = new Cell[9][9];
    
    //Instantiate the players from the PieceFactory
    for(int i = 0; i < thePlayers.length; i++) {
      thePlayers[i] = PieceFactory.getPiece(("Player " + String.valueOf(i + 1)));
    }
    
    //Create button grid
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j] = new Cell(i, j);
        add(bttn[i][j]);
      }
    }
    
    //Add Players to Buttons
    for(int i = 0; i < thePlayers.length; i++) {
      bttn[thePlayers[i].getX()][thePlayers[i].getY()].setPiece(thePlayers[i]);
    }
    
    //Adding the chest and keys to the buttons
    bttn[chest.getX()][chest.getY()].setPiece(chest);
    bttn[monkey.getX()][monkey.getY()].setPiece(monkey);
    bttn[donkey.getX()][donkey.getY()].setPiece(donkey);
    bttn[keydisk.getX()][keydisk.getY()].setPiece(keydisk);
    bttn[pinkey.getX()][pinkey.getY()].setPiece(pinkey);
    bttn[keynote.getX()][keynote.getY()].setPiece(keynote);
    
    //Setting the background of all buttons to default, and disables them
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j].setBackground(null);
        bttn[i][j].setEnabled(false);
        this.revalidate();
        this.repaint();
      }
    }
    
    //Instantiates a vector of vectors to store the player's possible moves
    Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
    
    //Calls the calculateMoves() method from PlayerPiece to get the possibleMoves
    possibleMoves = ((PlayerPiece) thePlayers[0]).calculateMoves(bttn);
    Vector<Integer> rowList = possibleMoves.get(0);
    Vector<Integer> columnList = possibleMoves.get(1);
    
    //For all the possible moves, the color of the button is set to red and enabled for the player to click
    for(int m = 0; m < rowList.size(); m++) {
      bttn[rowList.get(m)][columnList.get(m)].setBackground(Color.red);
      bttn[rowList.get(m)][columnList.get(m)].setEnabled(true);
      bttn[thePlayers[0].getX()][thePlayers[0].getY()].setEnabled(true);
    }
  }
  
  //Method to get the array of buttons
  public Cell[][] getBttn() {
    return bttn;
  }
  
  //Adds an action listener to each of the buttons
  public void addCellListener(ActionListener e) {
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j].addActionListener(e);
      }
    }
  }
}
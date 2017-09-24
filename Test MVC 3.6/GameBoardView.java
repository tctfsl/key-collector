import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameBoardView extends JPanel {
  private ImageIcon image;
  private Cell[][] bttn = new Cell[9][9];
  private Piece playingPlayer;
  private Piece player1 = PieceFactory.getPiece("Player 1");
  private Piece player2 = PieceFactory.getPiece("Player 2");
  private Piece player3 = PieceFactory.getPiece("Player 3");
  private Piece player4 = PieceFactory.getPiece("Player 4");
  private ArrayList<Piece> thePlayers = new ArrayList<Piece>();
  private Piece monkey = PieceFactory.getPiece("monkey");
  private Piece donkey = PieceFactory.getPiece("donkey");
  private Piece keydisk = PieceFactory.getPiece("keydisk");
  private Piece pinkey = PieceFactory.getPiece("pinkey");
  private Piece keynote = PieceFactory.getPiece("keynote");
  
  public GameBoardView() {
    setLayout(new GridLayout(9, 9));
    
    //Add to array
    thePlayers.add(player1);
    thePlayers.add(player2);
    thePlayers.add(player3);
    thePlayers.add(player4);
    
    //Allow Player 1 to move first
    ((PlayerPiece) player1).setMoveAbility(1);
    playingPlayer = player1;
    
    //Create button grid
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j] = new Cell(i, j);
        add(bttn[i][j]);
      }
    }
    
    //Add Players to Buttons
	System.out.println("X: " + monkey.getX() + " Y: " + monkey.getY());
    bttn[player1.getX()][player1.getY()].setPiece(player1);
    bttn[player2.getX()][player2.getY()].setPiece(player2);
    bttn[player3.getX()][player3.getY()].setPiece(player3);
    bttn[player4.getX()][player4.getY()].setPiece(player4);
    bttn[monkey.getX()][monkey.getY()].setPiece(monkey);
	bttn[donkey.getX()][donkey.getY()].setPiece(donkey);
	bttn[keydisk.getX()][keydisk.getY()].setPiece(keydisk);
	bttn[pinkey.getX()][pinkey.getY()].setPiece(pinkey);
	bttn[keynote.getX()][keynote.getY()].setPiece(keynote);
  }
  
  public Cell[][] getBttn() {
    return bttn;
  }
  
  public void addCellListener(ActionListener e) {
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j].addActionListener(e);
      }
    }
  }
  
  public ArrayList<Piece> getThePlayers() {
    return thePlayers;
  }
}
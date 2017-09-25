import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GameBoardView extends JPanel {
  private Cell[][] bttn;
  private Piece[] thePlayers = new Piece[4];
  
  private Piece monkey = PieceFactory.getPiece("monkey");
  private Piece donkey = PieceFactory.getPiece("donkey");
  private Piece keydisk = PieceFactory.getPiece("keydisk");
  private Piece pinkey = PieceFactory.getPiece("pinkey");
  private Piece keynote = PieceFactory.getPiece("keynote");
  private Piece chest = PieceFactory.getPiece("chest");
  
  public GameBoardView() {
    setLayout(new GridLayout(9, 9));
  
    bttn = new Cell[9][9];
    
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
    
    bttn[chest.getX()][chest.getY()].setPiece(chest);
    bttn[monkey.getX()][monkey.getY()].setPiece(monkey);
    bttn[donkey.getX()][donkey.getY()].setPiece(donkey);
    bttn[keydisk.getX()][keydisk.getY()].setPiece(keydisk);
    bttn[pinkey.getX()][pinkey.getY()].setPiece(pinkey);
    bttn[keynote.getX()][keynote.getY()].setPiece(keynote);
    
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        bttn[i][j].setBackground(null);
        bttn[i][j].setEnabled(false);
        this.revalidate();
        this.repaint();
      }
    }
    
    Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
    possibleMoves = ((PlayerPiece) thePlayers[0]).calculateMoves(bttn);
    Vector<Integer> rowList = possibleMoves.get(0);
    Vector<Integer> columnList = possibleMoves.get(1);
    
    for(int m = 0; m < rowList.size(); m++) {
      bttn[rowList.get(m)][columnList.get(m)].setBackground(Color.red);
      bttn[rowList.get(m)][columnList.get(m)].setEnabled(true);
      bttn[thePlayers[0].getX()][thePlayers[0].getY()].setEnabled(true);
    }
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
}
import javax.swing.*;
import java.util.ArrayList;

public class InfoBoardModel {
	//players piece list
  private ArrayList<ImageIcon>[] pieceOwned = new ArrayList[4];
  
  //constructor
  public InfoBoardModel() {
    for(int i = 0; i < pieceOwned.length; i++) {
      pieceOwned[i] = new ArrayList<ImageIcon>();
    }
  }
  
  //add piece
  public void addPiece(int turn, ImageIcon imageIcon) {
    pieceOwned[turn].add(0, imageIcon); 
  }
  
  //get piece list
  public ArrayList<ImageIcon>[] getPieceOwned() {
    return pieceOwned; 
  }
}
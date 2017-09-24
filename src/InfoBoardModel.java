import javax.swing.*;
import java.util.ArrayList;

public class InfoBoardModel {
  private ArrayList<ImageIcon>[] pieceOwned = new ArrayList[4];
  
  public InfoBoardModel() {
    for(int i = 0; i < pieceOwned.length; i++) {
      pieceOwned[i] = new ArrayList<ImageIcon>();
    }
  }
  
  public void addPiece(int turn, ImageIcon imageIcon) {
    pieceOwned[turn].add(0, imageIcon);
  }
  
  public ArrayList<ImageIcon>[] getPieceOwned() {
    return pieceOwned;
  }
}
import javax.swing.*;
import java.util.ArrayList;

/**
 * The InfoBoardModel holds the information regarding the pieces obtained by the players.
 * The InfoBoardModel is part of Model-View-Controller Design Pattern for InfoBoard.
 *
 * @author Faisal, Khai Chuen
 */
public class InfoBoardModel {
  //Holds the images of piece owned by each player.
  private ArrayList<ImageIcon>[] pieceOwned = new ArrayList[4];
  
  //Class Constructor
  public InfoBoardModel() {
    for(int i = 0; i < pieceOwned.length; i++) {
      pieceOwned[i] = new ArrayList<ImageIcon>();
    }
  }
  
  //Add the image of piece obtained by the player.
  public void addPiece(int turn, ImageIcon imageIcon) {
    pieceOwned[turn].add(0, imageIcon);
  }
  
  //Return the pieceOwned.
  public ArrayList<ImageIcon>[] getPieceOwned() {
    return pieceOwned;
  }
}
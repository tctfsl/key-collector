import java.util.ArrayList;
import java.util.Vector;

/**
 * PlayerPiece is one of the child class to the abstract Piece class.
 *
 * @author Faisal, Megat, Miguel
 */
public class PlayerPiece extends Piece {
  private Piece newestPiece;
  private ArrayList<Piece> keysHeld;
  
  public PlayerPiece(String name, String path, int row, int column) {
    super(name, path, row, column);
  
    newestPiece = null;
    keysHeld = new ArrayList<Piece>();
  }
  
  public Piece getPiece() {
    return this.keysHeld.get(keysHeld.size() - 1);
  }
  
  public void setNewestPiece(Piece key) {
    this.newestPiece = key;
  }
  
  public void addPiece(Piece piece) {
    this.keysHeld.add(0, piece);
  }
  
  public boolean isKeyHeld(Piece piece) {
    boolean held = true;
  
    for(int i = 0; i < keysHeld.size(); i++) {
      if ((keysHeld.get(i).getName()).equals(piece.getName())) {
        held = false;
      }
    }
    
    return held;
  }
  
  public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn) {
    //Initialize vectors to store the rows and positions of the possible moves which can be made by the player
    Vector<Vector<Integer>> merged = new Vector<Vector<Integer>>();
    
    if (newestPiece == null) {
      Vector<Integer> rowList = new Vector<Integer>(1, 1);
      Vector<Integer> columnList = new Vector<Integer>(1, 1);
      
      for(int i = (this.getX() - 2); i < (this.getX() + 3); i++) {
        for(int j = (this.getY() - 2); j < (this.getY() + 3); j++) {
          if ((i >= 0) && (j >= 0) && (i <= 8) && (j <= 8) && ((i == this.getX() || j == this.getY()) || (Math.abs(i - this.getX()) == Math.abs(j - this.getY())))) {
            //If the button is not occupied, adds the button to possible moves
            if (bttn[i][j].getIsOccupied() == false) {
              rowList.add(i);
              columnList.add(j);
            }
            else {
              //If the button contains the treasure chest, AND the player has all five keys, then the button is added to the possible moves
              if ((bttn[i][j].getPiece() instanceof Chest) && (keysHeld.size() == 5)) {
                rowList.add(i);
                columnList.add(i);
              }
              else {
                //If the button contains a piece, but its, not a PlayerPiece, and its not a TreasureChest, it is a key and is added to the possible moves
                if (!((bttn[i][j].getPiece() instanceof PlayerPiece) || (bttn[i][j].getPiece() instanceof Chest))) {
                  rowList.add(i);
                  columnList.add(j);
                }
              }
            }
          }
        }
      }
      
      merged.add(rowList);
      merged.add(columnList);
    }
    else {
      if (newestPiece instanceof Monkey) {
        merged = ((Monkey) newestPiece).calculateMoves(bttn, this.getX(), this.getY(), this.keysHeld);
      }
      else {
        if (newestPiece instanceof Pinkey) {
          merged = ((Pinkey) newestPiece).calculateMoves(bttn, this.getX(), this.getY(), this.keysHeld);
        }
        else {
          if (newestPiece instanceof Donkey) {
            merged = ((Donkey) newestPiece).calculateMoves(bttn, this.getX(), this.getY(), this.keysHeld);
          }
          else {
            if (newestPiece instanceof KeyDisk) {
              merged = ((KeyDisk) newestPiece).calculateMoves(bttn, this.getX(), this.getY(), this.keysHeld);
            }
            else {
              if (newestPiece instanceof KeyNote) {
                merged = ((KeyNote) newestPiece).calculateMoves(bttn, this.getX(), this.getY(), this.keysHeld);
              }
            }
          }
        }
      }
    }
  
    //The merged vector contains the vector of rows and the vector of columns in sequence according to the possible moves
    return merged;
  }
}
import java.util.ArrayList;
import java.util.Vector;

/**
 * Donkey is one of the child class to the abstract Piece class.
 *
 * @author Faisal, Megat, Miguel
 */
public class Donkey extends Piece {
  //Class Constructor.
  //Invokes parent's constructor.
  public Donkey(String name, String path, int x, int y) {
    super(name, path, x, y);
  }
  
  //Method requires the button parameter to check if a button is occupied, the players position, and the keys held by the player to buttons which should be enabled
  public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn, int playerRow, int playerColumn, ArrayList<Piece> keysHeld) {
    
    //Initialize vectors to store the rows and positions of the possible moves which can be made by the player
    Vector<Integer> rowList = new Vector<Integer>(1, 1);
    Vector<Integer> columnList = new Vector<Integer>(1, 1);
    
    for(int i = (playerRow - 3); i < (playerRow + 4); i++) {
      for(int j = (playerColumn - 3); j < (playerColumn + 4); j++) {
        if (i >= 0 && j >= 0 && i <= 8 && j <= 8 && (Math.abs(i - playerRow) == Math.abs(j - playerColumn))) {
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
    
    Vector<Vector<Integer>> merged = new Vector<Vector<Integer>>();
    merged.add(rowList);
    merged.add(columnList);
    
    //The merged vector contains the vector of rows and the vector of columns in sequence according to the possible moves
    return merged;
  }
}
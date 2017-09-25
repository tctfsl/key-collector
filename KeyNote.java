import java.util.ArrayList;
import java.util.Vector;

public class KeyNote extends Piece {
  public KeyNote(String name, String path, int x, int y) {
    super(name, path, x, y);
  }
  
  public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn, int playerRow, int playerColumn, ArrayList<Piece> keysHeld) {
    Vector<Integer> rowList = new Vector<Integer>(1, 1);
    Vector<Integer> columnList = new Vector<Integer>(1, 1);
    
    for(int i = (playerRow - 2); i < (playerRow + 3); i++) {
      for(int j = (playerColumn - 2); j < (playerColumn + 3); j++) {
        if (i >= 0 && j >= 0 && i <= 8 && j <= 8 && ((Math.abs(i - playerRow) > 1) || (Math.abs(j - playerColumn) > 1)) && ((Math.abs(i - playerRow) == Math.abs(j - playerColumn)) || (i == playerRow || j == playerColumn))) {
          if (bttn[i][j].getIsOccupied() == false) {
            rowList.add(i);
            columnList.add(j);
          }
          else {
            if ((bttn[i][j].getPiece() instanceof Chest) && (keysHeld.size() == 5)) {
              rowList.add(i);
              columnList.add(i);
            }
            else {
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
    
    return merged;
  }
}
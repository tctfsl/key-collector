import java.util.ArrayList;

public class InfoBoardModel {
  private ArrayList<Piece>[] pieceOwned = new ArrayList[4];
  
  public InfoBoardModel() {
  
  }
  
  public void addPiece(int turn,Piece piece) {
    pieceOwned[turn].add(0, piece);
  }
  
  public ArrayList<Piece>[] getPieceOwned() {
    return pieceOwned;
  }
}

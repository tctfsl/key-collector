public class GameBoardModel {
  private Piece[] thePlayers;
  private int turn;
  
  public GameBoardModel() {
    thePlayers = new Piece[4];
    
    for(int i = 0; i < thePlayers.length; i++) {
      thePlayers[i] = PieceFactory.getPiece(("Player " + String.valueOf(i + 1)));
    }
    
    turn = 1;
  }
  
  public int getTurn() {
    return turn;
  }
  
  public Piece[] getThePlayers() {
    return thePlayers;
  }
  
  //Cycles turn from 1 to 4
  public void goNext() {
    turn++;
    
    if (turn > 4) {
      turn = (turn % 4);
    }
  }
}
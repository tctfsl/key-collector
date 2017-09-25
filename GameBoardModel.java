public class GameBoardModel {
	/*
	@author Megat;
	*/
  private Piece[] thePlayers;
  private int turn;
  
  public GameBoardModel() {
	//Array to store players
    thePlayers = new Piece[4];
    
	//Initializing the players from the PieceFactory
    for(int i = 0; i < thePlayers.length; i++) {
      thePlayers[i] = PieceFactory.getPiece(("Player " + String.valueOf(i + 1)));
    }
    
	//Set the turn to 1
    turn = 1;
  }
  
  //Method to get which player's turn it is to move
  public int getTurn() {
    return turn;
  }
  
  //Method to get the array of players
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
import java.util.ArrayList;

public class BoardModel{
	private Piece player = PieceFactory.getPiece("Player 1");
	private Piece player2 = PieceFactory.getPiece("Player 2");
	private Piece player3 = PieceFactory.getPiece("Player 3");
	private Piece player4 = PieceFactory.getPiece("Player 4");
	ArrayList<Piece> thePlayers = new ArrayList<Piece>();
	private int turn = 1;

	BoardModel(){
		thePlayers.add(player);
		thePlayers.add(player2);
		thePlayers.add(player3);
		thePlayers.add(player4);
	}
	
	public void setTurn(int turn){
		this.turn = turn;
	}
	
	public void goNext(){
		turn++;
		if (turn > 4){
			turn = (turn % 4);
		}
	}
	
	public void goBack(){
		turn--;
	}
	
	public int getTurn(){
		return turn;
	}

	public ArrayList<Piece> getThePlayers(){
		return thePlayers;
	}

}
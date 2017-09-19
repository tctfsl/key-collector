import java.util.ArrayList;

public class PlayerPiece extends Piece {
	private ArrayList<Cell> possibleMoves;
	
	public PlayerPiece(int num) {
		super(("Player " + String.valueOf(num)), ("icons/" + String.valueOf(num) + ".gif"));
	}
	
	public void setPossibleMoves(ArrayList<Cell> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}
}
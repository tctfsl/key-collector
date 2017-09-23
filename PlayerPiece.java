import java.util.ArrayList;

public class PlayerPiece extends Piece {
	private ArrayList<Cell> possibleMoves;
	private int row;
	private int column;
	private int moveAbility;
	
	public PlayerPiece(String name, String path, int row, int column) {
		super(name, path, row, column);
		moveAbility = 1;
	}
	
	public void setPossibleMoves(ArrayList<Cell> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}
}
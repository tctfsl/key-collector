import java.util.ArrayList;

public class PlayerPiece extends Piece{
	private ArrayList<Cell> possibleMoves;
	private int x;
	private int y;
	private int moveAbility;
	
	public void setMoveAbility(int moveAbility){
		this.moveAbility = moveAbility;
	}
	
	public int getMoveAbility(){
		return moveAbility;
	}

	public PlayerPiece(String name, String path, int row, int column) {
		super(name, path, row, column);
		moveAbility = 0;
	}
	
	public void setPossibleMoves(ArrayList<Cell> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}
}
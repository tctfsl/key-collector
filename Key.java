import java.util.Vector;

abstract class Key extends Piece{
	public Key(String name, String path, int x, int y){
		super(name, path, x, y);
		
	}
	
	public abstract Vector<Vector<Integer>> calculateMoves(Cell[][] bttn, int playerRow, int playerColumn);
}
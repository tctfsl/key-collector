import java.util.ArrayList;
import java.util.Vector;

public class PlayerPiece extends Piece {
	private Piece newestPiece = null;
	
	public PlayerPiece(String name, String path, int row, int column) {
		super(name, path, row, column);
	}
	
	public void setNewestPiece(Piece key)
	{
		this.newestPiece = key;
	}
	
	public Piece getNewestPiece()
	{
		return newestPiece;
	}
	
	public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn)
	{
		Vector<Vector<Integer>> merged = new Vector<Vector<Integer>>();
		if(newestPiece == null)
		{
			Vector<Integer> rowList = new Vector<Integer>(1,1);
			Vector<Integer> columnList = new Vector<Integer>(1,1);
			
			for(int i=(this.getX()-2); i<(this.getX()+3); i++)
			{
				for(int j=(this.getY()-2); j<(this.getY()+3); j++)
				{
					if(i>=0 && j>=0 && i<=8 && j<=8)
					{
						if(bttn[i][j].isOccupied == false)
						{
								rowList.add(i);
								columnList.add(j);
						}
						
						else
						{
							if(bttn[i][j].getPiece() instanceof PlayerPiece);
							else
							{
								rowList.add(i);
								columnList.add(j);
							}
						}
					}
				}
			}
			
			merged.add(rowList);
			merged.add(columnList);
		}
		else
		{
			if(newestPiece instanceof Monkey)
			{
				merged = ((Monkey)newestPiece).calculateMoves(bttn, this.getX(), this.getY());
			}
			
			else if(newestPiece instanceof Pinkey)
			{
				merged = ((Pinkey)newestPiece).calculateMoves(bttn, this.getX(), this.getY());
			}
			
			else if(newestPiece instanceof Donkey)
			{
				merged = ((Donkey)newestPiece).calculateMoves(bttn, this.getX(), this.getY());
			}
			
			else if(newestPiece instanceof KeyDisk)
			{
				merged = ((KeyDisk)newestPiece).calculateMoves(bttn, this.getX(), this.getY());
			}
			
			else if(newestPiece instanceof KeyNote)
			{
				merged = ((KeyNote)newestPiece).calculateMoves(bttn, this.getX(), this.getY());
			}
			
			//merged = ((newestPiece.getClass())newestPiece).calculateMoves(bttn, this.getX(), this.getY());
		}
		
		return merged;
	}
}
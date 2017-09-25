import java.util.ArrayList;
import java.util.Vector;

public class Pinkey extends Piece {
  public Pinkey(String name, String path, int x, int y) {
    super(name, path, x, y);
  }
  
  public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn, int playerRow, int playerColumn)
	{
		Vector<Integer> rowList = new Vector<Integer>(1,1);
		Vector<Integer> columnList = new Vector<Integer>(1,1);
		
		for(int i = (playerRow-1); i < (playerRow+2); i++)
		{
			for(int j=(playerColumn-1); j<(playerColumn+2); j++)
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
		
		Vector<Vector<Integer>> merged = new Vector<Vector<Integer>>();
		merged.add(rowList);
		merged.add(columnList);
		return merged;
	}
}
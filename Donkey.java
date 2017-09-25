import java.util.Vector;

public class Donkey extends Piece {
  public Donkey(String name, String path, int x, int y) {
    super(name, path, x, y);
  }
  
  public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn, int playerRow, int playerColumn)
	{
		Vector<Integer> rowList = new Vector<Integer>(1,1);
		Vector<Integer> columnList = new Vector<Integer>(1,1);
		
		for(int i=(playerRow-3); i<(playerRow+4); i++)
		{
			for(int j=(playerColumn-3); j<(playerColumn+4); j++)
			{
				if(i>=0 && j>=0 && i<=8 && j<=8 && (Math.abs(i-playerRow)==Math.abs(j-playerColumn)))
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

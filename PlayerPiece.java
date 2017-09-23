import java.util.ArrayList;
import java.util.Vector;

public class PlayerPiece extends Piece {
	private ArrayList<Cell> possibleMoves;
	private Piece newestPiece = null;
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
	
	public Piece getNewestPiece()
	{
		return newestPiece;
	}
	
	public Vector<Vector<Integer>> calculateMoves(Cell[][] bttn)
	{
		Vector<Integer> rowList = new Vector<Integer>(1,1);
		Vector<Integer> columnList = new Vector<Integer>(1,1);
		//Vector<Vector<int>> calculatedList = new Vector<Vector<int>>();
		//int[][] calculatedList = new int[9][9];
		//ArrayList<Cell> calculatedList = new ArrayList<Cell>();
		
		for(int i=(this.row-2); i<(this.row+3); i++)
		{
			for(int j=(this.column-2); j<(this.column+3); j++)
			{
				if(i>=0 && j>=0 && i<=9 && j<=9)
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
							/*
							if(calculatedList.length>=1)
							{
								calculatedList[calculatedList.length+1][0] = i;
								calculatedList[calculatedList.length+1][1] = j;
							}
							else
							{
								calculatedList[calculatedList.length][0] = i;
								calculatedList[calculatedList.length][1] = j;
							}*/
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
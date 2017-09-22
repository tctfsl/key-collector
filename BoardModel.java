public class BoardModel{
	Piece piece = PieceFactory.getPiece("monkey");
	
	private static int turn = 1;
	
	public Piece getPiece(){
		return piece;
	}
	
	public int getTurn()
	{
		return turn;
	}
	
	public void changeTurn()
	{
		if(turn == 5 )
		{
			turn = 1;
		}
		
		turn = turn%5;
		turn++;	
	}
	
	
	
}
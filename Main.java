public class Main{
	public static void main (String [] args){
		System.out.println("Hello ");
		
		KeyDisk keyDisk = new KeyDisk();
		System.out.println(keyDisk.identify());
		
		Monkey monkey = new Monkey();
		System.out.println(monkey.identify());
		
		Piece piece = PieceFactory.getPiece("monkey");
		System.out.println(piece.identify());
		
	}
	
}
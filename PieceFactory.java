import java.util.concurrent.ThreadLocalRandom;

public class PieceFactory {
	public static Piece getPiece(String criteria) {
	int min = 1;
	int max = 8;
	int randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
	int randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
	
    if (criteria.equals("monkey")) {
		
      return new Monkey("Monkey", "monkey.gif", randomNumX, randomNumY);
	  
    } else if (criteria.equals("keydisk")) {
		
		return new KeyDisk("KeyDisk", "keydisk.gif", randomNumX, randomNumY);
		
	} else if (criteria.equals("donkey")) {
		
		return new Donkey("Donkey", "donkey.gif", randomNumX, randomNumY);
		
	} else if (criteria.equals("pinkey")) {
		
		return new Pinkey("Pinkey", "pinkey.gif", randomNumX, randomNumY);
		
	} else if (criteria.equals("keynote")) {
		
		return new KeyNote("KeyNote", "keynote.gif", randomNumX, randomNumY);
		
	} else if (criteria.equals("Player 1")) {
		
	  return new PlayerPiece("Player 1", "1.gif", 0, 0);
	  
	} else if (criteria.equals("Player 2")) {
		
		return new PlayerPiece("Player 2", "2.gif", 0, 8);
		
	} else if (criteria.equals("Player 3")) {
		
	  return new PlayerPiece("Player 3", "3.gif", 8, 0);
	  
	} else if (criteria.equals("Player 4")) {
		
		return new PlayerPiece("Player 4", "4.gif", 8, 8);
		
	} else {
		
		return null;
		
	}
	}
}
 

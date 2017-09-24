public class PieceFactory {
  public static Piece getPiece(String criteria) {
    if (criteria.equals("monkey")) {
      return new Monkey("Monkey", "monkey.gif", 5, 5);
    } else {
      if (criteria.equals("keydisk")) {
        return new KeyDisk("KeyDisk", "keydisk.gif", 5, 6);
      } else {
        if (criteria.equals("Player 1")) {
          return new PlayerPiece("Player 1", "1.gif", 0, 0);
        } else {
          if (criteria.equals("Player 2")) {
            return new PlayerPiece("Player 2", "2.gif", 0, 8);
          } else {
            if (criteria.equals("Player 3")) {
              return new PlayerPiece("Player 3", "3.gif", 8, 0);
            } else {
              if (criteria.equals("Player 4")) {
                return new PlayerPiece("Player 4", "4.gif", 8, 8);
              } else {
                return null;
              }
            }
          }
        }
      }
    }
  }
}
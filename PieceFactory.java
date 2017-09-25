/**
 * The PieceFactory is used to create Piece object without having to specify the exact class.
 * The PieceFactory uses the Factory Design Pattern.
 *
 * @author Megat
 */
public class PieceFactory {
  public static Piece getPiece(String criteria) {
    
    if (criteria.equals("monkey")) {
      return new Monkey("Monkey", "monkey.gif", 5, 7);
    } else {
      if (criteria.equals("keydisk")) {
        return new KeyDisk("KeyDisk", "keydisk.gif", 1, 4);
      } else {
        if (criteria.equals("donkey")) {
          return new Donkey("Donkey", "donkey.gif", 8, 5);
        } else {
          if (criteria.equals("pinkey")) {
            return new Pinkey("Pinkey", "pinkey.gif", 3, 4);
          } else {
            if (criteria.equals("keynote")) {
              return new KeyNote("KeyNote", "keynote.gif", 4, 1);
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
                      if (criteria.equals("chest")) {
                        return new Chest("chest", "chest.gif", 4, 4);
                      }
                      else {
                        return null;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


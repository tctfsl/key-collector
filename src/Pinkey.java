import java.util.ArrayList;

public class Pinkey extends Piece {
  private ArrayList<Cell> possibleMoves;
  
  public Pinkey() {
    super("Pinkey", "icons/pinkey.gif");
  }
  /*
  private ArrayList<Cell> setPossibleMove(int x, int y) {
    int[][] movePattern = {{x, y + 1}, {x, y - 1}, {x + 1, y}, {x - 1, y},
                           {x + 1, y + 1}, {x + 1, y - 1}, {x - 1, y + 1}, {x - 1, y - 1}};
    
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 2; j++) {
      
      }
    }
    
    for(int i = 0; i < 8; i++)
      if((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i]<8))
        if((state[posx[i]][posy[i]].getpiece() == null || state[posx[i]][posy[i]].getpiece().getcolor() != this.getcolor()))
          possibleMoves.add(state[posx[i]][posy[i]]);
    return possibleMoves;
  }*/
}
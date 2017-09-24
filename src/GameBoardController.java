import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameBoardController {
  private GameBoardView theView;
  private GameBoardModel theModel;
  private int rowToMove = 0;
  private int columnToMove = 0;
  private ArrayList<Piece> players = new ArrayList<Piece>();
  
  public GameBoardController(GameBoardView theView, GameBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
  
    theView.addCellListener(new CellListener());
  }
  
  public void setRowToMove(int rowToMove) {
    this.rowToMove = rowToMove;
  }
  
  public void setColumnToMove(int columnToMove) {
    this.columnToMove = columnToMove;
  }
  
  private class CellListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      //Copy Model ArrayList to BoardController ArrayList
      players = theModel.getThePlayers();
      System.out.println(players.size());
      
      //Check Player turn
      System.out.println("Player " + theModel.getTurn() + " Turn.");
      
      InfoBoardController.updateGameInfo(theModel.getTurn());
      
      //I got the Source. No Ketchup.
      Cell btn = (Cell) e.getSource();
      
      if (btn.getPiece() == null) {
        System.out.println("No Piece Here");
        
        //[ArrayList] Set Player Piece
        btn.setPiece(players.get(theModel.getTurn() - 1));
        
        //[ArrayList] Set New Piece Location
        players.get(theModel.getTurn() - 1).setX(btn.getRow());
        players.get(theModel.getTurn() - 1).setY(btn.getColumn());
        
        //Remove Previous Piece from View
        theView.getBttn()[rowToMove][columnToMove].removePiece();
      }
      else {
        System.out.println("Piece Here");
      }
      
      //Go to Next Player;
      theModel.goNext();
      
      //Get Next Player's Piece Location
      rowToMove = players.get(theModel.getTurn() - 1).getX();
      columnToMove = players.get(theModel.getTurn() - 1).getY();
    }
    
    public int getTurn() {
      return theModel.getTurn();
    }
  }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
	  
	  for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			theView.getBttn()[i][j].setBackground(null);
			theView.getBttn()[i][j].setEnabled(false);
			theView.revalidate();
			theView.repaint();
			}
		}
		
	
      
      //Check Player turn
      System.out.println("Player " + theModel.getTurn() + " Turn.");

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
		
		
        //players.get(theModel.getTurn()).calculateMoves(theView.getBttn());
		
		//Go to Next Player;
        theModel.goNext();

        InfoBoardController.updateGameInfo(theModel.getTurn());
      }
	  
	  else if (btn.isOccupied==true && !(btn.getPiece() instanceof PlayerPiece))
	  {
		  System.out.println("Key here");
		  ((PlayerPiece)players.get(theModel.getTurn() - 1)).setNewestPiece(btn.getPiece());
		  btn.removePiece();
		  //[ArrayList] Set Player Piece
          btn.setPiece(players.get(theModel.getTurn() - 1));
          //[ArrayList] Set New Piece Location
          players.get(theModel.getTurn() - 1).setX(btn.getRow());
          players.get(theModel.getTurn() - 1).setY(btn.getColumn());
        
          //Remove Previous Piece from View
          theView.getBttn()[rowToMove][columnToMove].removePiece();
		
		
          //players.get(theModel.getTurn()).calculateMoves(theView.getBttn());
		
		  //Go to Next Player;
          theModel.goNext();

        InfoBoardController.updateGameInfo(theModel.getTurn());
	  }
      else {
        System.out.println("Piece Here");
      }
      
	  //Getting Possible Moves for next Player
		Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
		possibleMoves = ((PlayerPiece)players.get(theModel.getTurn()-1)).calculateMoves(theView.getBttn());
		
		if(possibleMoves.size()>=1)
		{
			Vector<Integer> rowList = possibleMoves.get(0);
			Vector<Integer> columnList = possibleMoves.get(1);
			
			for(int m=0; m<rowList.size(); m++)
			{
				theView.getBttn()[rowList.get(m)][columnList.get(m)].setBackground(Color.red);
				theView.getBttn()[rowList.get(m)][columnList.get(m)].setEnabled(true);
				theView.getBttn()[players.get(theModel.getTurn()-1).getX()][players.get(theModel.getTurn()-1).getY()].setEnabled(true);
			}
		}
      
      //Get Next Player's Piece Location
      rowToMove = players.get(theModel.getTurn() - 1).getX();
      columnToMove = players.get(theModel.getTurn() - 1).getY();
	  
	  
    }
    
    public int getTurn() {
      return theModel.getTurn();
    }
  }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoardController {
  private GameBoardView theView;
  private GameBoardModel theModel;
  private int rowToMove = 0;
  private int columnToMove = 0;
  private ArrayList<Piece> players = new ArrayList<Piece>();
  private int min = 1;
  private int max = 7;
  
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
      }
	  
	  else if (btn.isOccupied==true && !(btn.getPiece() instanceof PlayerPiece))
	  {
		  
		System.out.println("Key here");
		  
		int randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
		int randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		  ((PlayerPiece)players.get(theModel.getTurn() - 1)).setNewestPiece(btn.getPiece());
		  
		//Set New Piece on Board
		if (theView.getBttn()[randomNumX][randomNumY].isOccupied == false){
			System.out.println("Nice");
			theView.getBttn()[randomNumX][randomNumY].setPiece(btn.getPiece());
		} else {
			randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
			randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
			System.out.println("I DONT'T FEEL LIKE PUTTITNG ");
			while (theView.getBttn()[randomNumX][randomNumY].isOccupied == false){
			System.out.println("Add New Piece");
			randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
			randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
			System.out.println("Key: " + btn.getPiece());
			System.out.println("X2: " + randomNumX + " Y2: " + randomNumY);
			theView.getBttn()[randomNumX][randomNumY].setPiece(btn.getPiece());
			}
		}
		  
		  //add key to the list of keys the player has
		  if(((PlayerPiece)players.get(theModel.getTurn() - 1)).isKeyHeld(btn.getPiece()))
		  {
			  ((PlayerPiece)players.get(theModel.getTurn() - 1)).addPiece(btn.getPiece());
			  System.out.println("Added key");
			  System.out.println(theModel.getTurn() - 1);
			  System.out.println(((PlayerPiece)players.get(theModel.getTurn() - 1)).getKeySize());
		  }
		  System.out.println(((PlayerPiece)players.get(theModel.getTurn() - 1)).getNewestPiece().getName());
		  
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
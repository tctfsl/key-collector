import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoardController {
  private GameBoardView theView;
  private GameBoardModel theModel;
  private InfoBoardController infoBoardController;
  
  private int rowToMove;
  private int columnToMove;
  private Piece[] players;
  private int min;
  private int max;
  
  public GameBoardController(GameBoardView theView, GameBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
    
    theView.addCellListener(new CellListener());
  
    rowToMove = 0;
    columnToMove = 0;
    players = new Piece[4];
    min = 1;
    max = 7;
  }
  
  public void setInfoBoardController(InfoBoardController infoBoardController) {
    this.infoBoardController = infoBoardController;
  }
  
  private class CellListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      //Copy Model ArrayList to BoardController ArrayList
      players = theModel.getThePlayers();
      
      for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
          theView.getBttn()[i][j].setBackground(null);
          theView.getBttn()[i][j].setEnabled(false);
          theView.revalidate();
          theView.repaint();
        }
      }
      
      Cell destinationCell = (Cell) e.getSource();
  
      if(destinationCell.getPiece() instanceof Chest)
      {
        String winMsg = "Congratulations! " + players[theModel.getTurn() - 1].getName() + " has unlocked the treasure chest! VICTORY!";
        JOptionPane.showMessageDialog(null, winMsg);
        System.exit(0);
      }
      
      if (destinationCell.getPiece() == null) {
        //[ArrayList] Set Player Piece
        destinationCell.setPiece(players[theModel.getTurn() - 1]);
        
        //[ArrayList] Set New Piece Location
        players[theModel.getTurn() - 1].setX(destinationCell.getRow());
        players[theModel.getTurn() - 1].setY(destinationCell.getColumn());
        
        //Remove Previous Piece from View
        theView.getBttn()[rowToMove][columnToMove].removePiece();
        
        //Go to Next Player;
        theModel.goNext();
        infoBoardController.updatePlayerTurn(theModel.getTurn());
      }
      else {
        //If the destination cell is occupied by a piece, and the piece is not a player's piece
        if (destinationCell.getIsOccupied() == true && !(destinationCell.getPiece() instanceof PlayerPiece)) {
          int randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
          int randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
          
          ((PlayerPiece) players[theModel.getTurn() - 1]).setNewestPiece(destinationCell.getPiece());
    
          //Set New Piece on Board
          if (theView.getBttn()[randomNumX][randomNumY].getIsOccupied() == false) {
            theView.getBttn()[randomNumX][randomNumY].setPiece(destinationCell.getPiece());
          }
          else {
            randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
            randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
            
            while (theView.getBttn()[randomNumX][randomNumY].getIsOccupied() == false) {
              randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
              randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
              theView.getBttn()[randomNumX][randomNumY].setPiece(destinationCell.getPiece());
            }
          }
          
          //add key to the list of keys the player has
          if (((PlayerPiece) players[theModel.getTurn() - 1]).isKeyHeld(destinationCell.getPiece())) {
            ((PlayerPiece) players[theModel.getTurn() - 1]).addPiece(destinationCell.getPiece());
            
            java.net.URL imageURL = getClass().getResource(destinationCell.getPiece().getPath());
            ImageIcon image = new ImageIcon(imageURL);
            infoBoardController.updatePlayerInformation(theModel.getTurn() - 1, image);
          }
          
          destinationCell.removePiece();
          
          //[ArrayList] Set Player Piece
          destinationCell.setPiece(players[theModel.getTurn() - 1]);
          
          //[ArrayList] Set New Piece Location
          players[theModel.getTurn() - 1].setX(destinationCell.getRow());
          players[theModel.getTurn() - 1].setY(destinationCell.getColumn());
          
          //Remove Previous Piece from View
          theView.getBttn()[rowToMove][columnToMove].removePiece();
          
          //Go to Next Player;
          theModel.goNext();
          infoBoardController.updatePlayerTurn(theModel.getTurn());
        }
      }
      
      //Getting Possible Moves for next Player
      Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
      possibleMoves = ((PlayerPiece) players[theModel.getTurn() - 1]).calculateMoves(theView.getBttn());
      
      if (possibleMoves.size() >= 1) {
        Vector<Integer> rowList = possibleMoves.get(0);
        Vector<Integer> columnList = possibleMoves.get(1);
        
        for(int m = 0; m < rowList.size(); m++) {
          theView.getBttn()[rowList.get(m)][columnList.get(m)].setBackground(Color.red);
          theView.getBttn()[rowList.get(m)][columnList.get(m)].setEnabled(true);
          theView.getBttn()[players[theModel.getTurn() - 1].getX()][players[theModel.getTurn() - 1].getY()].setEnabled(true);
        }
      }
      
      //Get Next Player's Piece Location
      rowToMove = players[theModel.getTurn() - 1].getX();
      columnToMove = players[theModel.getTurn() - 1].getY();
    }
  }
}
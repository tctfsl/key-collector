import javax.swing.*;
import java.awt.Color;					//For setting the background color of the buttons
import java.awt.event.ActionEvent;		//To implement the ActionPerformed for the buttons
import java.awt.event.ActionListener;	//To implement the ActionListener for the buttons
import java.util.Vector;				//To implement a vector to store the possible moves of the players
import java.util.concurrent.ThreadLocalRandom;	//To randomly generate the keys after they are taken

/**
 *@author Megat, Miguel, Faisal;
 */

//Connects the GameBoardModel and the GameBoardView, and also contains the cell listener which essentially controls the flow of the game
public class GameBoardController {
  private GameBoardView theView;
  private GameBoardModel theModel;
  private InfoBoardController infoBoardController;
  
  //Indicates the row of the player which will be moved next
  private int rowToMove;
  //Indicates the column of the player which will be moved next
  private int columnToMove;
  
  //Stores the player objects
  private Piece[] players;
  //The minimum number to be randomly generated later
  private int min;
  //The maximum number to be randomly generated later
  private int max;
  
  public GameBoardController(GameBoardView theView, GameBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
    
    theView.addCellListener(new CellListener());
    //Set row and column to move to 0, because according to first player's position
    rowToMove = 0;
    columnToMove = 0;
    //Initialize the array of players
    players = new Piece[4];
    
    //Set the min to 1 and max to 7 according to the number of buttons which is 9x9 in this case
    min = 1;
    max = 7;
  }
  
  
  public void setInfoBoardController(InfoBoardController infoBoardController) {
    this.infoBoardController = infoBoardController;
  }
  
  //The listener for the buttons
  private class CellListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      //Copy Model Player array to the array in this class
      players = theModel.getThePlayers();
      
      //Set the color of all buttons back to default after displaying possible moves
      for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
          theView.getBttn()[i][j].setBackground(null);
          theView.getBttn()[i][j].setEnabled(false);
          theView.revalidate();
          theView.repaint();
        }
      }
      
      //Assign the pressed button to another cell
      Cell destinationCell = (Cell) e.getSource();
      
      //End game message when the player clicks the button where the treasure chest resides
      if(destinationCell.getPiece() instanceof Chest)
      {
        String winMsg = "Congratulations! " + players[theModel.getTurn() - 1].getName() + " has unlocked the treasure chest! VICTORY!";
        JOptionPane.showMessageDialog(null, winMsg);
        System.exit(0);
      }
      
      //If the button clicked does not contain any piece
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
          //generates random numbers to set a new key to a random position
          int randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
          int randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
          
          ((PlayerPiece) players[theModel.getTurn() - 1]).setNewestPiece(destinationCell.getPiece());
          //Preparing the image to be displayed later on the infoboard
          java.net.URL imageURL = getClass().getResource(destinationCell.getPiece().getPath());
          ImageIcon image = new ImageIcon(imageURL);
          //Calls a method from the InforBoardController to update player info
          infoBoardController.updatePlayerInformation(theModel.getTurn() - 1, image);
          
          //Set New Piece on Board
          if (theView.getBttn()[randomNumX][randomNumY].getIsOccupied() == false) {
            theView.getBttn()[randomNumX][randomNumY].setPiece(destinationCell.getPiece());
          }
          
          else {
            randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
            randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
            //If the position generated is already occupied, it generates it repeatedly
            while (theView.getBttn()[randomNumX][randomNumY].getIsOccupied() == true) {
              randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
              randomNumY = ThreadLocalRandom.current().nextInt(min, max + 1);
              //Sets the piece which is already taken to another button, therefore generating a new key
              theView.getBttn()[randomNumX][randomNumY].setPiece(destinationCell.getPiece());
            }
          }
          
          //Only adds a key which the player doesn't already have to their list of keys
          if (((PlayerPiece) players[theModel.getTurn() - 1]).isKeyHeld(destinationCell.getPiece())) {
            ((PlayerPiece) players[theModel.getTurn() - 1]).addPiece(destinationCell.getPiece());
          }
          
          //Removes the key which is already in the button
          destinationCell.removePiece();
          
          //Sets the player piece into the button
          destinationCell.setPiece(players[theModel.getTurn() - 1]);
          
          //Sets the new location to be moved later, which is the next player's position
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
        
        //Sets the buttons which can be moved to by the player to red, and also disables the other buttons from being clicked
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
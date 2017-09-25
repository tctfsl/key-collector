import javax.swing.*;
import java.awt.*;

/**
 * Cell objects makes up the game board of the game.
 *
 * @author Faisal, Khai Chuen, Megat, Miguel
 */
public class Cell extends JButton {
  /**
   * row and column are used to determine the location of the cell in the game board.
   * image stores the picture of piece in the cell.
   * piece is an movable object that could be a player, a key, or a chest.
   * isOccupied is used to indicate if there is a piece on the cell.
   */
  private int row;
  private int column;
  private ImageIcon image;
  private Piece piece;
  private boolean isOccupied = false;
  
  //Class Constructor
  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
    this.image = null;
    this.piece = null;
    this.isOccupied = false;
    setPreferredSize(new Dimension(50, 50));
  }
  
  //Getter for row
  public int getRow() {
    return row;
  }
  
  //Getter for column
  public int getColumn() {
    return column;
  }
  
  //Getter for piece
  public Piece getPiece() {
    return piece;
  }
  
  //Getter for isOccupied
  public boolean getIsOccupied() {
    return isOccupied;
  }
  
  //Setter for piece
  public void setPiece(Piece piece) {
    this.piece = piece;
    this.isOccupied = true;
    this.setImage();
  }
  
  //Removes the piece from the cell
  public void removePiece() {
    this.piece = null;
    this.isOccupied = false;
    this.setIcon(null);
  }
  
  //Invoked by the piece setter
  //Get the image of the piece and set it to the cell.
  private void setImage() {
    java.net.URL imgURL = getClass().getResource(this.piece.getPath());
    image = new ImageIcon(imgURL);
    this.setIcon(image);
  }
}
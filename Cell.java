import java.awt.Dimension;
import javax.swing.*;

public class Cell extends JButton
{
  private int row;
  private int column;
  public ImageIcon image;
  public Piece piece;
  public boolean isOccupied;
  
  public Cell(int row, int column) {
	  this.row = row;
	  this.column = column;
	  this.isOccupied = false;
    setPreferredSize(new Dimension(50, 50));
  }

  public int getRow() {
	  return row;
  }
  
  public int getColumn() {
	  return column;
  }
  
  public Piece getPiece() {
	  return piece;
  }

  public void setPiece(Piece piece) {
	  this.piece = piece;
	  this.setImage();
	  this.isOccupied = true;
  }
  
  public void removePiece() {
	  this.piece = null;
	  this.isOccupied = false;
	  this.setIcon(null);
  }
  
  private void setImage()
  {
	  ImageIcon image = createImageIcon(this.piece.getPath(), "Something");
	  //this.image = new ImageIcon(getClass().getResource(this.piece.getPath()));
	  this.setIcon(image);
  }
  
  protected ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
  }
  
}
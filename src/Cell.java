import java.awt.Dimension;
import javax.swing.*;

public class Cell extends JButton
{
  private int row;
  private int column;
  private ImageIcon image;
  private Piece piece;
  private boolean isOccupied;
  
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
  }
  
  private void setImage()
  {
	  this.image = new ImageIcon(getClass().getResource(this.piece.getPath()));
	  this.setIcon(image);
  }
}
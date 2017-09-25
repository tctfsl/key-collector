import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
  private int row;
  private int column;
  private ImageIcon image;
  private Piece piece;
  private boolean isOccupied = false;
  
  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
    this.image = null;
    this.piece = null;
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
  
  public boolean getIsOccupied() {
    return isOccupied;
  }
  
  public void setPiece(Piece piece) {
    this.piece = piece;
    this.isOccupied = true;
    this.setImage();
  }
  
  public void removePiece() {
    this.piece = null;
    this.isOccupied = false;
    this.setIcon(null);
  }
  
  private void setImage() {
    java.net.URL imgURL = getClass().getResource(this.piece.getPath());
    image = new ImageIcon(imgURL);
    this.setIcon(image);
  }
}
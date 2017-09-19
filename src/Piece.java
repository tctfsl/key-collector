public abstract class Piece
{
  private String name;
  private String path;
  private int x;
  private int y;
  
  public Piece() {
  
  }
  
  public Piece(String name, String path)
  {
	  this.name = name;
	  this.path = path;
  }

  public String getPath() {
    return path;
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
}
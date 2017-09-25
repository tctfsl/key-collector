public abstract class Piece {
  private String name;
  private String path;
  private int x;
  private int y;
  
  //Constructor
  public Piece(String name, String path, int x, int y) {
    this.name = name;
    this.path = path;
    this.x = x;
    this.y = y;
  }
  
  public String getName() {
    return name;
  }
  
  //Get image file name
  public String getPath() {
    return path;
  }
  
  //Get x coordinate
  public int getX() {
    return x;
  }
  
   //Get y coordinate
  public int getY() {
    return y;
  }
   //Set x coordinate
  public void setX(int x) {
    this.x = x;
  }
  
   //Get y coordinate
  public void setY(int y) {
    this.y = y;
  }
}
public abstract class Piece{
	private String name;
	private String path;
	private int x;
	private int y;
	
	public String getName(){
		return name;
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
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public Piece(String name, String path){
		this.name = name;
		this.path = path;
	}
	
	public String identify(){
		return "name: " + this.getName() + ", Path: " + this.getPath();
	}
	
}
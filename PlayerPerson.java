import javax.swing.*;
import java.util.ArrayList;

public class PlayerPerson extends Piece{
	private String name = " ";
	private ImageIcon image;
	private String path = " ";
	private ArrayList<Piece> piecesOwned;
	private int x;
	private int y;
	private Piece piece;
	
	public Piece getPiece(){
		return piece;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public PlayerPerson(String aName, aPath){
		super(aName, aPath);
	}
	
	public void move(){
		if (piece.getPiece() == null){
			
		}
	}
}
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.*;

public class BoardController{
	static private BoardView view;
	private BoardModel model;
	private int rowToMove = 0;
	private int columnToMove = 0;
	private ArrayList<Piece> players = new ArrayList<Piece>();

	public void setRowToMove(int rowToMove){
		this.rowToMove = rowToMove;
	}
	
	public void setColumnToMove(int columnToMove){
		this.columnToMove = columnToMove;
	}
	
	public BoardController(BoardView view, BoardModel model){
		this.view = view;
		this.model = model;
		
		view.addCellListener(new CellListener());
	}
	
	private class CellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		//Copy Model ArrayList to BoardController ArrayList
		players = model.getThePlayers();
		System.out.println(players.size());
		 
		//Check Player turn
		System.out.println("Player " + model.getTurn() + " Turn.");
		//I got the Source. No Ketchup.
		Cell btn = (Cell) e.getSource();

		if (btn.getPiece() == null){
			System.out.println("No Piece Here");
			
			//[ArrayList] Set Player Piece
			btn.setPiece(players.get(model.getTurn()-1));
						
			//[ArrayList] Set New Piece Location
			players.get(model.getTurn()-1).setX(btn.getRow());
			players.get(model.getTurn()-1).setY(btn.getColumn());
			
			//Remove Previous Piece from View
			view.bttn[rowToMove][columnToMove].removePiece();			

		} else {
			System.out.println("Piece Here");
		}
			
		//Go to Next Player;
		model.goNext();
		//Get Next Player's Piece Location
		rowToMove = players.get(model.getTurn()-1).getX();
		columnToMove = players.get(model.getTurn()-1).getY();
		}
	}
}
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class BoardController{
	static private BoardView view;
	private BoardModel model;
	private int rowToMove = 0;
	private int columnToMove = 0;
	
	public BoardController(BoardView view, BoardModel model){
		this.view = view;
		this.model = model;
		
		view.addCellListener(new CellListener());
	}
	
	private class CellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Cell btn = (Cell) e.getSource();
			System.out.println("Negro");
			//((Cell)e.getSource()).setBackground(Color.red);
			//System.out.println(view.bttn[0][1].getColumn());
			
			if(btn.isOccupied==false) {
				btn.setPiece(view.bttn[rowToMove][columnToMove].getPiece());
				view.bttn[rowToMove][columnToMove].removePiece();

				rowToMove = btn.getRow();
				columnToMove = btn.getColumn();
				System.out.println("Row: " + btn.getRow() + " Column: " + btn.getColumn());
			}
		}
	}
	
	/*private class CellMovement implements ActionListener{
		public void actionPerformed(ActionEvent e){
		Cell btn = (Cell) e.getSource();
		System.out.println("character");
		((Cell)e.getSource()).setBackground(Color.red);
		System.out.println("Row: " + btn.getRow() + " Column: " + btn.getColumn());
		}
	}*/
}
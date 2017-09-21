import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class BoardController{
	private BoardView view;
	private BoardModel model;
	
	public BoardController(BoardView view, BoardModel model){
		this.view = view;
		this.model = model;
		
		view.addCellListener(new CellListener());
	}
	
	private class CellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		Cell btn = (Cell) e.getSource();
		System.out.println("Negro");
		((Cell)e.getSource()).setBackground(Color.red);
		System.out.println("Row: " + btn.getRow() + " Column: " + btn.getColumn());
		}
	}
}
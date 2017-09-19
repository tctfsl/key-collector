import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardView extends JFrame{
	private ImageIcon image;
	private Cell btnOne = new Cell(0,0);
	private Cell btnTwo = new Cell(0,0);
	
	public JButton getButtonOne(){
		return btnOne;
	}
	
	public JButton getButtonTwo(){
		return btnTwo;
	}
	
	public void setButtonTwo(Piece piece){
		btnTwo.setPiece(piece);
	}
	
	public void setButtonOne(Piece piece){
		btnOne.setPiece(piece);
	}
	
	public Cell accessCellOne(){
		return btnOne;
	}
	
	public Cell accessCellTwo(){
		return btnTwo;
	}
	BoardView(){
		JPanel boardPanel = new JPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
	
		boardPanel.add(btnOne);
		boardPanel.add(btnTwo);
		
		this.add(boardPanel);
	}
	
	void addMoveListener(ActionListener listenForButton){
		btnOne.addActionListener(listenForButton);
    }
	
	void addMoveListener2(ActionListener listenForButton){
		btnTwo.addActionListener(listenForButton);
    }
	
	public createGameBoard(){
		
	}

	
}
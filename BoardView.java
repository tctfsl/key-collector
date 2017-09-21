import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class BoardView extends JFrame{
	private ImageIcon image;
	Cell[][] bttn = new Cell[9][9];
	
	BoardView(){
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(9, 9));
		
		for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			bttn[i][j] = new Cell(i, j);
			boardPanel.add(bttn[i][j]);
			}
		}
		//this.setLayout(new GridLayout(9, 9));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
		this.add(boardPanel);
	}
	
	void addCellListener(ActionListener e){
		for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			bttn[i][j].addActionListener(e);
			}
		}
	}
	
}
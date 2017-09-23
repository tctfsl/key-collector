import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BoardView extends JFrame{
	Cell[][] btn = new Cell[9][9];

	
	public BoardView(JFrame frame)
	{
		JPanel leftPanel = new JPanel();
		
  
		leftPanel.setLayout(new GridLayout(9, 9, 2, 2));
    
		for(int i = 0; i < 9; i++) 
		{
			for(int j = 0; j < 9; j++) 
			{
				//String text = String.valueOf(i) + ", " + String.valueOf(j);
				//btn[i][j] = new JButton(text);
				btn[i][j] = new Cell(i,j);
				btn[i][j].setPreferredSize(new Dimension(45, 45));
			
				btn[i][j].setBackground(Color.WHITE);
				leftPanel.add(btn[i][j]);
				leftPanel.setBackground(Color.BLACK);
			}
		}
		frame.add(leftPanel);

	}
	

	void addCellListener(ActionListener e){
		for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			btn[i][j].addActionListener(e);
			}
		}
	}
	
}
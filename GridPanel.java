import java.awt.*;
import javax.swing.*;

public class GridPanel extends JPanel
{
  private JPanel innerPanel = new JPanel();
  private JButton[][] bttn = new JButton[9][9];
  
  public GridPanel()
  {
    innerPanel.setLayout(new GridLayout(9, 9, 3, 3));
	
	for(int i = 0; i < 9; i++)
	{
	  for(int j = 0; j < 9; j++)
	  {
	    bttn[i][j] = new JButton(String.valueOf(i) + ", " + String.valueOf(j));
	    bttn[i][j].setPreferredSize(new Dimension(60, 50));
	    innerPanel.add(bttn[i][j]);
	  }
	}
	
    add(innerPanel, BorderLayout.CENTER);
  }
}
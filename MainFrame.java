import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
  JPanel gridPanel = new GridPanel();
  JPanel scorePanel = new ScorePanel();
  
  public static void main(String[] args)
  {
	JFrame runGame = new MainFrame();
  }
  
  public MainFrame()
  {
	super("TCP2201 Game");
	
	add(gridPanel);
	add(scorePanel);
	
	setLayout(new GridLayout(1, 2));
	//setSize(1024, 640);
	this.pack();
	setVisible(true);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
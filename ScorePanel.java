import java.awt.*;
import javax.swing.*;

public class ScorePanel extends JPanel
{
  private JLabel p1 = new JLabel("Ban Gei");
  private JLabel p2 = new JLabel("Ark Imides");
  private JLabel p3 = new JLabel("Can Ser");
  private JLabel p4 = new JLabel("Doz Ciztem");
  
  public ScorePanel()
  {
	super(new FlowLayout());
	
	add(p1);
	add(p2);
	add(p3);
	add(p4);	
  }
}
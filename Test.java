import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Test extends JFrame {
  
  public Test() {
    super("Another Test");
    
    //---( Above is no edit zone )--------------------------------------------------
    //---( Below is to edit JFrame property )---------------------------------------
    
    setLayout(new FlowLayout());
    setPreferredSize(new Dimension(1500, 470));
  
    //---( Below is no edit zone )--------------------------------------------------
  
    JPanel leftPanel = new JPanel();
    JButton[][] btn = new JButton[9][9];
  
    leftPanel.setLayout(new GridLayout(9, 9, 2, 2));
    
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        //String text = String.valueOf(i) + ", " + String.valueOf(j);
        //btn[i][j] = new JButton(text);
        btn[i][j] = new JButton();
        btn[i][j].setPreferredSize(new Dimension(45, 45));
        
        btn[i][j].setBackground(Color.WHITE);
        leftPanel.add(btn[i][j]);
      }
    }
    
    leftPanel.setBackground(Color.BLACK);
    //---( Below is to edit right panel component )---------------------------------
    
    JPanel p1Panel = new JPanel();
    p1Panel.setLayout(new GridLayout(1, 15));
    p1Panel.setPreferredSize(new Dimension(800, 100));
    java.net.URL link = getClass().getResource("1.gif");
    ImageIcon image = new ImageIcon(link);
    JButton piece;
    
    for(int j = 0; j < 15; j++) {
      //piece = new JButton(String.valueOf(j));
      piece = new JButton();
      piece.setIcon(image);
      piece.setPreferredSize(new Dimension(45,45));
      p1Panel.add(piece);
    }
    
    JScrollPane scroll = new JScrollPane(p1Panel);
    scroll.setPreferredSize(new Dimension(200, 100));
    
    //---( Below is no edit zone )--------------------------------------------------
    
    TitledBorder tested;
    tested = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Player Information");
    
    JPanel rightPanel = new JPanel();
    JLabel justText = new JLabel("Player Information");
    
    rightPanel.setPreferredSize(new Dimension(350, 421));
    rightPanel.setLayout(new BorderLayout());
    
    rightPanel.add(justText);
    rightPanel.setBorder(tested);
    //rightPanel.add(p1Panel, BorderLayout.PAGE_START);
    rightPanel.add(scroll, BorderLayout.CENTER);
    //rightPanel.add(p1Panel, BorderLayout.PAGE_END);
  
    //---( Below is to add component to JFrame )------------------------------------
    
    add(leftPanel);
    add(rightPanel);
    
    //---( Below is no edit zone )--------------------------------------------------
    
    pack();
    setVisible(true);
  }
  
  public static void main(String[] args) {
    Test newTest = new Test();
  }
}

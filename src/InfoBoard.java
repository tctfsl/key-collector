import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

public class InfoBoard extends  JPanel {
  private static InfoBoard infoBoard = new InfoBoard();
  //private JButton[] bttn = new JButton[8];
  
  private JLabel labelP1;
  private JLabel labelP2;
  private JLabel labelP3;
  private JLabel labelP4;
  
  private JPanel panelP1;
  private JPanel panelP2;
  private JPanel panelP3;
  private JPanel panelP4;
  
  private InfoBoard() {
  }
  
  public static InfoBoard getInfoBoard() {
    return infoBoard;
  }
  
  public void createInfoBoard() {
    
    setPreferredSize(new Dimension(300, 500));
    setLayout(new GridLayout(8, 1, 5, 10));
    
    /*
    for(int i = 0; i < 8; i++) {
      bttn[i] = new JButton(String.valueOf(i));
      add(bttn[i]);
    }
    */
  
    JLabel labelP1 = new JLabel("Player 1");
    JPanel panelP1 = new JPanel(new FlowLayout());
    panelP1.setBackground(Color.WHITE);
    
    JLabel labelP2 = new JLabel("Player 2");
    JPanel panelP2 = new JPanel(new FlowLayout());
    panelP2.setBackground(Color.WHITE);
    
    JLabel labelP3 = new JLabel("Player 3");
    JPanel panelP3 = new JPanel(new FlowLayout());
    panelP3.setBackground(Color.WHITE);
    
    JLabel labelP4 = new JLabel("Player 4");
    JPanel panelP4 = new JPanel(new FlowLayout());
    panelP4.setBackground(Color.WHITE);
  
    add(labelP1);
    add(panelP1);
    add(labelP2);
    add(panelP2);
    add(labelP3);
    add(panelP3);
    add(labelP4);
    add(panelP4);
  
  }
}

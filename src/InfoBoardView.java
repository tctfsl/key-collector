import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InfoBoardView extends JPanel {
  private JPanel gameInfo;
  private JPanel playerInfo;
  
  private TitledBorder titleWrapper1;
  private TitledBorder titleWrapper2;
  private Border loweredetch;
  private String title1;
  private String title2;
  
  private JLabel turnIndicator;
  
  private JPanel[] avatar = new JPanel[4];
  private JLabel avatarLabel;
  private JScrollPane[] pieceListScroll = new JScrollPane[4];
  private JPanel[] pieceList = new JPanel[4];
  
  public InfoBoardView(ImageIcon[] avatarIcon) {
    setLayout(new FlowLayout());
    setPreferredSize(new Dimension(350, 450));
  
    title1 = "Game Information";
    loweredetch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    titleWrapper1 = BorderFactory.createTitledBorder(loweredetch, title1);
    
    gameInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
    gameInfo.setPreferredSize(new Dimension(350, 80));
    gameInfo.setBorder(titleWrapper1);
  
    turnIndicator = new JLabel("Turn: Player 1");
    
    gameInfo.add(turnIndicator);
    
    title2 = "Player Information";
    titleWrapper2 = BorderFactory.createTitledBorder(loweredetch, title2);
    
    playerInfo = new JPanel(new FlowLayout());
    playerInfo.setPreferredSize(new Dimension(350, 350));
    playerInfo.setBorder(titleWrapper2);
    
    for(int i = 0; i < avatarIcon.length; i++) {
      avatar[i] = new JPanel();
      
      avatar[i].setPreferredSize(new Dimension(75, 75));
      avatar[i].setLayout(new BorderLayout());
      avatar[i].setBackground(Color.WHITE);
      avatar[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
      
      avatarLabel = new JLabel("Player " + (i + 1), avatarIcon[i], JLabel.CENTER);
      avatarLabel.setVerticalTextPosition(JLabel.BOTTOM);
      avatarLabel.setHorizontalTextPosition(JLabel.CENTER);
      avatar[i].add(avatarLabel);
    }
    
    for(int j = 0; j < avatar.length; j++) {
      pieceList[j] = new JPanel();
      
      pieceListScroll[j] = new JScrollPane(pieceList[j]);
      pieceListScroll[j].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
      pieceListScroll[j].setPreferredSize(new Dimension(250, 76));
    }
    
    for(int k = 0; k < avatar.length; k++) {
      playerInfo.add(avatar[k]);
      playerInfo.add(pieceListScroll[k]);
    }
    
    add(gameInfo);
    add(playerInfo);
  }
  
  public void updatePlayerInfo(int turn, InfoBoardModel theModel) {
    ImageIcon image;
    JButton button;
    java.net.URL imageURL;
  
    pieceList[turn].removeAll();
    
    for(int i = 0; i < theModel.getPieceOwned()[turn].size(); i++) {
      imageURL = getClass().getResource(theModel.getPieceOwned()[turn].get(i).getPath());
      image = new ImageIcon(imageURL);
      
      button = new JButton();
      button.setPreferredSize(new Dimension(45, 45));
      
      pieceList[turn].add(button);
    }
  }
  
  //DEBUGGING CODES
  public static void main(String[] args) {
    ImageIcon[] avatarIcon = new ImageIcon[4];
    
    java.net.URL imgURL1 = InfoBoardView.class.getClassLoader().getResource("1.gif");
    java.net.URL imgURL2 = InfoBoardView.class.getResource("2.gif");
    java.net.URL imgURL3 = InfoBoardView.class.getResource("3.gif");
    java.net.URL imgURL4 = InfoBoardView.class.getResource("4.gif");
    
    System.out.println(imgURL1);
    
    avatarIcon[0] = new ImageIcon(imgURL1);
    avatarIcon[1] = new ImageIcon(imgURL2);
    avatarIcon[2] = new ImageIcon(imgURL3);
    avatarIcon[3] = new ImageIcon(imgURL4);
    
    JFrame aFrame = new JFrame("Test MVC");
    InfoBoardView run = new InfoBoardView(avatarIcon);
    
    aFrame.add(run);
    aFrame.setLayout(new FlowLayout());
    aFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    aFrame.pack();
    aFrame.setVisible(true);
  }
}

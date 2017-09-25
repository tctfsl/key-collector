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
  
  private static JLabel turnIndicator;
  
  private JPanel[] avatar = new JPanel[4];
  private JLabel avatarLabel;
  private JScrollPane[] pieceListScroll = new JScrollPane[4];
  private JPanel[] pieceList = new JPanel[4];
  
  //Class Constructor
  public InfoBoardView() {
    setLayout(new FlowLayout());
    setPreferredSize(new Dimension(360, 450));
    
    //Prepare the border styling for both Game Information and Player Information panels.
    loweredetch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    
    //Prepare the title and the border for Game Information panel.
    title1 = "Game Information";
    titleWrapper1 = BorderFactory.createTitledBorder(loweredetch, title1);
    
    //Set up the Game Information panel.
    gameInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
    gameInfo.setPreferredSize(new Dimension(360, 93));
    gameInfo.setBorder(titleWrapper1);
    
    //Prepare the component for the Game Information panel.
    turnIndicator = new JLabel("Turn: Player 1");
    
    //Add the component into the Game Information panel.
    gameInfo.add(turnIndicator);
    
    //Prepare the title and the border for Player Information panel.
    title2 = "Player Information";
    titleWrapper2 = BorderFactory.createTitledBorder(loweredetch, title2);
    
    //Set up the Player Information panel.
    playerInfo = new JPanel(new FlowLayout());
    playerInfo.setPreferredSize(new Dimension(360, 350));
    playerInfo.setBorder(titleWrapper2);
    
    //Prepare the  components for the Player Information panel.
    Piece[] players = new Piece[4];
    java.net.URL imageURL;
    ImageIcon image;
    
    for(int m = 0; m < 4; m++) {
      players[m] = PieceFactory.getPiece(("Player " + String.valueOf(m + 1)));
    }
    
    for(int i = 0; i < 4; i++) {
      avatar[i] = new JPanel();
      avatar[i].setPreferredSize(new Dimension(75, 75));
      avatar[i].setLayout(new BorderLayout());
      avatar[i].setBackground(Color.WHITE);
      avatar[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
      
      imageURL = getClass().getResource(players[i].getPath());
      image = new ImageIcon(imageURL);
      
      avatarLabel = new JLabel("Player " + (i + 1), image, JLabel.CENTER);
      avatarLabel.setVerticalTextPosition(JLabel.BOTTOM);
      avatarLabel.setHorizontalTextPosition(JLabel.CENTER);
      
      avatar[i].add(avatarLabel);
    }
    
    for(int j = 0; j < avatar.length; j++) {
      pieceList[j] = new JPanel(new FlowLayout(FlowLayout.LEFT));
      
      pieceListScroll[j] = new JScrollPane(pieceList[j]);
      pieceListScroll[j].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
      pieceListScroll[j].setPreferredSize(new Dimension(260, 76));
    }
    
    //Add the components to the Player Information panel.
    for(int k = 0; k < avatar.length; k++) {
      playerInfo.add(avatar[k]);
      playerInfo.add(pieceListScroll[k]);
    }
    
    //Add both panels to the View.
    add(gameInfo);
    add(playerInfo);
  }
  
  
  public void updateTurnIndicator(int turn) {
    gameInfo.removeAll();
    turnIndicator = new JLabel("Turn: Player " + String.valueOf(turn));
    gameInfo.add(turnIndicator);
  }
  
  public void updatePieceOwned(int turn, InfoBoardModel theModel) {
    ImageIcon image;
    JButton button;
    
    pieceList[turn].removeAll();
    
    for(int i = 0; i < theModel.getPieceOwned()[turn].size(); i++) {
      image = theModel.getPieceOwned()[turn].get(i);
      button = new JButton(image);
      button.setPreferredSize(new Dimension(45, 45));
      
      if (i == 0) {
        button.setBackground(Color.BLUE);
      }
      else {
        button.setEnabled(false);
      }
      
      pieceList[turn].add(button);
    }
    
    this.revalidate();
  }
}

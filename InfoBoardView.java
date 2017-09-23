import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InfoBoardView extends JPanel {
	private ImageIcon[] avatarIcon = new ImageIcon[4];
	private JPanel infoBoard = new JPanel();
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
  
  
  public InfoBoardView(JFrame frame) {
 
			
		for(int i = 0; i < 4; i++)
		{
			String s1 = String.valueOf(i+1);
			String img = (s1 + ".gif");
			java.net.URL imgURL =getClass().getResource(img);
			avatarIcon[i] = new ImageIcon(imgURL);
		}
    
		infoBoard.setLayout(new FlowLayout());
		infoBoard.setPreferredSize(new Dimension(350, 450));
  
		title1 = "Game Information";
		loweredetch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		titleWrapper1 = BorderFactory.createTitledBorder(loweredetch, title1);
    
		gameInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		gameInfo.setPreferredSize(new Dimension(350, 80));
		gameInfo.setBorder(titleWrapper1);
		
		//String q = String.valueOf(model.getTurn());
		turnIndicator = new JLabel("Turn: Player");
    
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
    
			infoBoard.add(gameInfo);
			infoBoard.add(playerInfo);
			frame.add(infoBoard);
  }
  

}
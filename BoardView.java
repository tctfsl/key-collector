import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BoardView extends JFrame{
	Cell[][] btn = new Cell[9][9];
	BoardModel model;
	
	
	public BoardView()
	{
		super("Key Collector");
		this.setLayout(new GridLayout(1,2));
		leftGameBoard(this);
		rightGameBoard(this);
		
		this.pack();

	}
	

	
	void leftGameBoard(JFrame frame)
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
	
	void rightGameBoard(JFrame frame)
	{
		ImageIcon[] avatarIcon = new ImageIcon[4];
		
		
		for(int i = 0; i < 4; i++)
		{
			String s1 = String.valueOf(i+1);
			String img = (s1 + ".gif");
			java.net.URL imgURL =getClass().getResource(img);
			avatarIcon[i] = new ImageIcon(imgURL);
		}
    
		 JPanel infoBoard = new JPanel();
		 JPanel gameInfo;
		 JPanel playerInfo;
  
		 TitledBorder titleWrapper1;
		 TitledBorder titleWrapper2;
		 Border loweredetch;
		 String title1;
		 String title2;
  
		 JLabel turnIndicator;
  
		 JPanel[] avatar = new JPanel[4];
		 JLabel avatarLabel;
		 JScrollPane[] pieceListScroll = new JScrollPane[4];
		 JPanel[] pieceList = new JPanel[4];
  
	
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
	

	

	
	void addCellListener(ActionListener e){
		for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			btn[i][j].addActionListener(e);
			}
		}
	}
	
}
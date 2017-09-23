import javax.swing.*;
import java.awt.*;

class Board extends JFrame{
	private InfoBoardView infoBoard;
	private BoardView boardview;
	
	public Board()
	{
		super("Key Collector");
		this.setLayout(new GridLayout(1,2));
		boardview = new BoardView(this);
	    infoBoard = new InfoBoardView(this);
		
		BoardModel model = new BoardModel();
		BoardController controller = new BoardController(boardview, model);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	
}
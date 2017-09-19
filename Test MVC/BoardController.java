import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardController{
	private BoardView view;
	private BoardModel model;
	public BoardController(BoardView view, BoardModel model){
		this.view = view;
		this.model = model;
		this.view.addMoveListener(new MoveButton());
		this.view.addMoveListener2(new MoveButton2());
	}
	
	class MoveButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			view.setButtonOne(model.getPiece());
			view.accessCellTwo().setIcon(null);
		}
	}
	
	class MoveButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			view.setButtonTwo(model.getPiece());
			view.accessCellOne().setIcon(null);
		}
	}
}
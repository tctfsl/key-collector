public class BoardMVC{
	public static void main(String[] args)
	{
		BoardModel model = new BoardModel();
		BoardView view = new BoardView();
		BoardController controller = new BoardController(view, model);
		view.setVisible(true);
	}
	
}
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Faisal, Khai Chuen, Miguel
 */
public class MainFrame extends JFrame {
  //Class Constructor
  public MainFrame(InfoBoardView infoBoardView, GameBoardView gameBoardView) {
    super("Key Collector Game (JGroup)");
    setLayout(new FlowLayout());
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  
    add(gameBoardView);
    add(infoBoardView);
    
    //Set the size of the frame according to its components.
    pack();
    setVisible(true);
  }
  
  public static void main(String[] args) {
    GameBoardView gameBoardView = new GameBoardView();
    InfoBoardView infoBoardView = new InfoBoardView();
  
    GameBoardModel gameBoardModel = new GameBoardModel();
    InfoBoardModel infoBoardModel = new InfoBoardModel();
    
    GameBoardController gameBoardController = new GameBoardController(gameBoardView, gameBoardModel);
    InfoBoardController infoBoardController = new InfoBoardController(infoBoardView, infoBoardModel, gameBoardController);
    gameBoardController.setInfoBoardController(infoBoardController);
    
    MainFrame mainFrame = new MainFrame(infoBoardView, gameBoardView);
  }
}

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MainFrame extends JFrame {
  
  public MainFrame(InfoBoardView infoBoardView, GameBoardView gameBoardView) {
    super("Key Collector Game (JGroup)");
    setLayout(new FlowLayout());
    //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  
    add(gameBoardView);
    add(infoBoardView);
    
    pack();
    setVisible(true);
  }
  
  public static void main(String[] args) {
    
    ImageIcon[] avatarIcon = new ImageIcon[4];
  
    java.net.URL imgURL1 = InfoBoardView.class.getResource("1.gif");
    java.net.URL imgURL2 = InfoBoardView.class.getResource("2.gif");
    java.net.URL imgURL3 = InfoBoardView.class.getResource("3.gif");
    java.net.URL imgURL4 = InfoBoardView.class.getResource("4.gif");
  
    avatarIcon[0] = new ImageIcon(imgURL1);
    avatarIcon[1] = new ImageIcon(imgURL2);
    avatarIcon[2] = new ImageIcon(imgURL3);
    avatarIcon[3] = new ImageIcon(imgURL4);
  
    GameBoardView gameBoardView = new GameBoardView();
    InfoBoardView infoBoardView = new InfoBoardView(avatarIcon);
  
    GameBoardModel gameBoardModel = new GameBoardModel();
    InfoBoardModel infoBoardModel = new InfoBoardModel();
    
    GameBoardController gameBoardController = new GameBoardController(gameBoardView, gameBoardModel);
    InfoBoardController infoBoardController = new InfoBoardController(infoBoardView, infoBoardModel);
    
    MainFrame mainFrame = new MainFrame(infoBoardView, gameBoardView);
    
    /*
    Scanner reader = new Scanner(System.in);
    
    System.out.print("Enter yes: ");
    int input = reader.nextInt();
    
    System.out.print(input);
    
    if (input == 1) {
      java.net.URL imgURLX = InfoBoardView.class.getResource("monkey.gif");
      ImageIcon newImg = new ImageIcon(imgURLX);
      
      //Piece dummy = PieceFactory.getPiece("monkey");
      //System.out.println(dummy.identify());
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      infoBoardController.updateModel(1, newImg);
      System.out.println("Can update model");
      infoBoardController.updateView(1);
      System.out.println("LOL");
    }
    */
  }
}

import javax.swing.*; //DEBUGGING ONLY
import java.awt.*; //DEBUGGING ONLY
import java.util.Scanner; //DEBUGGING ONLY

public class InfoBoardController {
  private InfoBoardView theView;
  private InfoBoardModel theModel;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
  }
  
  public void updateModel(int turn, ImageIcon imageIcon) {
    this.theModel.addPiece(turn, imageIcon);
  }
  
  public void updateView(int turn) {
    this.theView.updatePlayerInfo(turn, theModel);
  }
  
  public static void main(String[] args) {
    /**
     * when running, enter 1 in the console
     * It will add buttons to one of the player
     */
    
    ImageIcon[] avatarIcon = new ImageIcon[4];
  
    java.net.URL imgURL1 = InfoBoardView.class.getResource("1.gif");
    java.net.URL imgURL2 = InfoBoardView.class.getResource("2.gif");
    java.net.URL imgURL3 = InfoBoardView.class.getResource("3.gif");
    java.net.URL imgURL4 = InfoBoardView.class.getResource("4.gif");
  
    avatarIcon[0] = new ImageIcon(imgURL1);
    avatarIcon[1] = new ImageIcon(imgURL2);
    avatarIcon[2] = new ImageIcon(imgURL3);
    avatarIcon[3] = new ImageIcon(imgURL4);
    
    InfoBoardView theView = new InfoBoardView(avatarIcon);
    InfoBoardModel theModel = new InfoBoardModel();
    
    InfoBoardController theController = new InfoBoardController(theView, theModel);
  
    JFrame aFrame = new JFrame("Test MVC");
  
    aFrame.add(theView);
    aFrame.setLayout(new FlowLayout());
    aFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    aFrame.pack();
    aFrame.setVisible(true);
    
    Scanner reader = new Scanner(System.in);
    
    System.out.print("Enter yes: ");
    int input = reader.nextInt();
    
    System.out.print(input);
    
    if (input == 1) {
      java.net.URL imgURLX = InfoBoardView.class.getResource("monkey.gif");
      ImageIcon newImg = new ImageIcon(imgURLX);
      
      //Piece dummy = PieceFactory.getPiece("monkey");
      //System.out.println(dummy.identify());
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      theController.updateModel(1, newImg);
      System.out.println("Can update model");
      theController.updateView(1);
      System.out.println("LOL");
  
      //aFrame.setVisible(true);
    }
  }
}

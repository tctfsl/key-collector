import javax.swing.*;

public class InfoBoardController {
  private static InfoBoardView theView;
  private static InfoBoardModel theModel;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
  }
  
  public static void updateGameInfo(int turn) {
    theView.updateTurnIndicator(turn);
  }
  
  public static void updateModel(int turn, ImageIcon imageIcon) {
    theModel.addPiece(turn, imageIcon);
  }
  
  public static void updatePlayerInfo(int turn) {
    theView.updatePieceOwned(turn, theModel);
  }
}

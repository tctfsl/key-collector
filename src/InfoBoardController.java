import javax.swing.*;

public class InfoBoardController {
  private static InfoBoardView theView;
  private InfoBoardModel theModel;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
  }
  
  public static void updateGameInfo(int turn) {
    theView.updateTurnIndicator(turn);
  }
  
  public void updateModel(int turn, ImageIcon imageIcon) {
    this.theModel.addPiece(turn, imageIcon);
  }
  
  public void updatePlayerInfo(int turn) {
    this.theView.updatePieceOwned(turn, theModel);
  }
}

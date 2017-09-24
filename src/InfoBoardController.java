import javax.swing.*;

public class InfoBoardController {
  private InfoBoardView theView;
  private InfoBoardModel theModel;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
  }
  
  public void updateTurnIndicator(int turn) {
    this.theView.updateGameInfo(turn);
  }
  
  public void updateModel(int turn, ImageIcon imageIcon) {
    this.theModel.addPiece(turn, imageIcon);
  }
  
  public void updateView(int turn) {
    this.theView.updatePlayerInfo(turn, theModel);
  }
}

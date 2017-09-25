import javax.swing.*;

public class InfoBoardController {
  private static InfoBoardView theView;
  private InfoBoardModel theModel;
  private GameBoardController gameBoardController;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel, GameBoardController gameBoardController) {
    this.theView = theView;
    this.theModel = theModel;
    this.gameBoardController = gameBoardController;
  }
  
  public void updatePlayerTurn(int turn) {
    theView.updateTurnIndicator(turn);
  }
  
  public void updatePlayerInformation(int turn, ImageIcon imageIcon) {
    this.theModel.addPiece(turn, imageIcon);
    this.theView.updatePieceOwned(turn, theModel);
  }
}

import javax.swing.*;

/**
 * The InfoBoardController connects the InfoBoardModel and InfoBoardView.
 * The InfoBoardController is part of Model-View-Controller Design Pattern for InfoBoard.
 *
 * @author Faisal, Khai Chuen
 */
public class InfoBoardController {
  private static InfoBoardView theView;
  private InfoBoardModel theModel;
  private GameBoardController gameBoardController;
  
  //Class Constructor.
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel, GameBoardController gameBoardController) {
    this.theView = theView;
    this.theModel = theModel;
    this.gameBoardController = gameBoardController;
  }
  
  //Update the Game Information panel.
  public void updatePlayerTurn(int turn) {
    theView.updateTurnIndicator(turn);
  }
  
  //Update the Player Information panel.
  public void updatePlayerInformation(int turn, ImageIcon imageIcon) {
    this.theModel.addPiece(turn, imageIcon);
    this.theView.updatePieceOwned(turn, theModel);
  }
}

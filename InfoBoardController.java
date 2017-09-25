import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class InfoBoardController implements Observer{
  private static InfoBoardView theView;
  private InfoBoardModel theModel;
  private GameBoardModel gameBoardModel;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel, GameBoardModel gameBoardModel) {
    this.theView = theView;
    this.theModel = theModel;
    this.gameBoardModel = gameBoardModel;
  }
  
  public void update(Observable observable, Object object) {
    if (this.gameBoardModel == observable) {
      this.theView.updateTurnIndicator(gameBoardModel.getTurn());
    }
  }
  
  public void updateModel(int turn, ImageIcon imageIcon) {
    this.theModel.addPiece(turn, imageIcon);
  }
  
  public void updatePlayerInfo(int turn) {
    this.theView.updatePieceOwned(turn, theModel);
  }
}

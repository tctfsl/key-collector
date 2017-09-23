public class InfoBoardController {
  private InfoBoardView theView;
  private InfoBoardModel theModel;
  
  public InfoBoardController(InfoBoardView theView, InfoBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
  }
  
  public void updateModel(int turn, Piece piece) {
    this.theModel.addPiece(turn, piece);
  }
  
  public void updateView(int turn) {
    this.theView.updatePlayerInfo(turn, theModel);
  }
}

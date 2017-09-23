import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.ArrayList;

public class BoardView extends JFrame{
	private ImageIcon image;
	Cell[][] bttn = new Cell[9][9];
	
	//To Do
	//1. Relocate Players to Model
	
	//Players
	Piece playingPlayer;
	Piece player = PieceFactory.getPiece("Player 1");
	Piece player2 = PieceFactory.getPiece("Player 2");
	Piece player3 = PieceFactory.getPiece("Player 3");
	Piece player4 = PieceFactory.getPiece("Player 4");
	
	//Players
	ArrayList<Piece> thePlayers = new ArrayList<Piece>();
	
	//Keys
	Piece monkey = PieceFactory.getPiece("monkey");
		
	//Piece player = new PlayerPiece("Emilia", "unknown.gif", 0, 0);
	BoardView(){
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(9, 9));
		
		//Add to Array
		thePlayers.add(player);
		thePlayers.add(player2);
		thePlayers.add(player3);
		thePlayers.add(player4);
		
		//Allow Player One to Move First 
		((PlayerPiece)player).setMoveAbility(1);
		playingPlayer = player;
		
		//Create button grid
		for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			bttn[i][j] = new Cell(i, j);
			boardPanel.add(bttn[i][j]);
			}
		}
		
		//Add Players to Buttons
		bttn[player.getX()][player.getY()].setPiece(player);
		bttn[player2.getX()][player2.getY()].setPiece(player2);
		bttn[player3.getX()][player3.getY()].setPiece(player3);
		bttn[player4.getX()][player4.getY()].setPiece(player4);
		bttn[monkey.getX()][monkey.getY()].setPiece(monkey);
		
		//this.setLayout(new GridLayout(9, 9));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
		this.add(boardPanel);
	}
	
	void addCellListener(ActionListener e){
		for(int i = 0; i < 9; i++) {
		  for(int j = 0; j < 9; j++){
			bttn[i][j].addActionListener(e);
			}
		}
	}
	
	public ArrayList<Piece> getThePlayers(){
		return thePlayers;
	}
	
}
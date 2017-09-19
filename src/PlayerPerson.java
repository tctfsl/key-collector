import javax.swing.*;
import java.util.*;

public class PlayerPerson {
	private String name;
	private ImageIcon image;
	private ArrayList<Piece> piecesOwned;
	
	private PlayerPerson(Builder PlayerPersonMaker){
		this.name = PlayerPersonMaker.name;
		this.image = PlayerPersonMaker.image;
		this.piecesOwned = PlayerPersonMaker.piecesOwned;
	}
	
	public static class Builder {
		private String name;
		private ImageIcon image;
		private ArrayList<Piece> piecesOwned;
		
		public Builder withName(String n) {
			name = n;
			return this;
		}
		public Builder withImage(ImageIcon i) {
			image = i;
			return this;
		}
		
		public Builder withPiecesOwned(ArrayList<Piece> pO) {
			piecesOwned = pO;
			return this;
		}
		
		public PlayerPerson build() {
			return new PlayerPerson(this);
		}
	}
}
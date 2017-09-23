
public class PlayerPerson{
	private String name;
	private String img;
	private ArrayList<piece>
	
	private PlayerPerson(Builder makePlayerPerson){
		this.name = makePlayerPerson.name;
		this.img = makePlayerPerson.img;	
	}
	
	public void move(){
		
	}
	
	public void PossibleMoves(){
		
	}
	
	public static class Builder{
		private String name;
		private String img;
		
		public Builder name(string n){name = n; return this}
		public Builder img(string i){img = i; return this}
		
		public PlayerPerson build(){
			return new PlayerPerson(this);
		}
	}
}
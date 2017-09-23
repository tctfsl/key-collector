class PieceFactory{
	public static Piece getPiece(String criteria){
		if (criteria.equals("monkey")){
			return new Monkey();
		} else if (criteria.equals("keydisk")) {
			return new KeyDisk();
		}
		else{
			return null;
		}
	}
}
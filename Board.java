package game;

public class Board {

	/** Board of objects. */
	public final static Object[][] boardArr = new Object[4][4];

	/** Returns object on board at x y if there is an object. */
	public static Object getPiece(int y, int x) {
		return boardArr[y][x];
	}

	/** Sets piece at x y if there isn't a piece already there. */
	public static void setPiece(int y, int x, Object piece) {
		try {
			if (Board.getPiece(y, x) == null){
				System.out.println("set piece");
				boardArr[y][x] = piece;
			}
			else{
				throw new Exception("There is already a piece there");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void winGame(){
		System.out.println("HIT. End game.");
	}

}

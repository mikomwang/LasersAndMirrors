package game;

public class Game {

	public static void main(String[] args) {
		/** Sets up the game board */
		Lasers playerRed = new Lasers(0, 3, "up");
		Lasers playerBlue = new Lasers(3, 0, "down");
		Mirrors mirrorOne = new Mirrors(1, 1, 1);
		Mirrors mirrorTwo = new Mirrors(2, 1, 2);
		Mirrors mirrorThree = new Mirrors(1, 2, 1);
		Mirrors mirrorFour = new Mirrors(2, 2, 1);
		Board.setPiece(0, 3, playerRed);
		Board.setPiece(3, 0, playerBlue);
		Board.setPiece(1, 1, mirrorOne);
		Board.setPiece(2, 1, mirrorTwo);
		Board.setPiece(1, 2, mirrorThree);
		Board.setPiece(2, 2, mirrorFour);
		
		playerRed.move("up");
		System.out.println(Board.getPiece(0, 0));
		
	}

}

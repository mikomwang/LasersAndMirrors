package game;

public class Mirrors {

	/** Coordinates x y of the mirror. */
	public int x, y;

	/** Orientations of mirror. */
	public int orient;

	/** Mirror objects on board at xy with orientation o. */
	public Mirrors(int x, int y, int o) {
		this.x = x;
		this.y = y;
		orient = o;
	}

	/** Moves mirror in direction d. */
	public void move(int direction){
		int prevX = x;
		int prevY = y;
		if (direction == 1){
			Board.setPiece(x, y + 1, this);
			y = y + 1;
			Board.setPiece(prevX, prevY, null);
		} else if (direction == 2){
			Board.setPiece(x, y - 1, this);
			y = y - 1;
			Board.setPiece(prevX, prevY, null);
		} else if (direction == 3){
			Board.setPiece(x - 1, y, this);
			x = x -1;
			Board.setPiece(prevX, prevY, null);
		} else if (direction == 4){
			Board.setPiece(x + 1, y, this);
			x = x + 1;
			Board.setPiece(prevX, prevY, null);
		}		
	}

	/** Rotates orientation. */
	public void rotate() {
		if (orient == 1) {
			orient = 2;
		} else {
			orient = 1;
		}
	}

}

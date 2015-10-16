package game;

public class Lasers {
	/** Coordinates for the laser */
	public int x, y;
	
	/** up, down, left, right*/
	public String direction;
	
	/** Constructor for a laser */
	public Lasers(int x, int y, String direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	/** Moves the piece in a given direction, either up, down, left, or right. */
	public void move(String direction){
		int prevX = x;
		int prevY = y;
		if (direction == "up"){
			Board.setPiece(y - 1, x, this);
			y = y - 1;
			Board.setPiece(prevY, prevX, null);
		} else if (direction == "down"){
			Board.setPiece(y + 1, x, this);
			y = y + 1;
			Board.setPiece(prevY, prevX, null);
		} else if (direction == "left"){
			Board.setPiece(y, x-1, this);
			x = x - 1;
			Board.setPiece(prevY, prevX, null);
		} else if (direction == "right"){
			Board.setPiece(y, x+1, this);
			x = x + 1;
			Board.setPiece(prevY, prevX, null);
		}		
	}
	
	/** Changes the direction of the piece. */
	public void rotate(){
		if (this.direction == "left"){
			this.direction = "up";
		}
		if (this.direction == "up"){
			this.direction = "left";
		}
		if (this.direction == "right"){
			this.direction = "down";
		}
		if (this.direction == "down"){
			this.direction = "right";
		}
	}
	
	public void shootVertical(int x1, int y1, String dir){
		/** Shoots down. */
		if (dir == "down"){
			for (int i = y1 + 1; i <= 3; i += 1){
				if (Board.getPiece(x1, i) instanceof Lasers){
					Board.winGame();
				}
				else if (Board.getPiece(x1,  i) instanceof Mirrors){
					Mirrors piece = (Mirrors) Board.getPiece(x1, i);
					if (piece.orient == 1){
						shootHorizontal(x1, i, "right");
					}
					else if (piece.orient == 2){
						shootHorizontal(x1, i, "left");
					}
				}
			}
		/** Shoots up. */
		} else if (dir == "up"){
			for (int i = y1 - 1; i >= 0; i -= 1){
				if (Board.getPiece(x1, i) instanceof Lasers){
					Board.winGame();
				}
				else if (Board.getPiece(x1, i) instanceof Mirrors){
					Mirrors piece = (Mirrors) Board.getPiece(x1, i);
					if (piece.orient == 1){
						shootHorizontal(x1, i, "left");
					}
					else if (piece.orient == 2){
						shootHorizontal(x1, i, "right");
					}
				}
			}
		}
	}
	
	public void shootHorizontal(int x1, int y1, String dir){
		if (dir == "left"){
			for (int i = x1 - 1; i >= 0; i -= 1){
				if (Board.getPiece(i, y1) instanceof Lasers){
					Board.winGame();
				}
				else if (Board.getPiece(i, y1) instanceof Mirrors){
					Mirrors piece = (Mirrors) Board.getPiece(i, y);
					if (piece.orient == 1){
						shootVertical(i, y1, "up");
					}
					else if (piece.orient == 2){
						shootVertical(i, y1, "down");
					}
				}
			}
			
		} else if (dir == "right"){
			for (int i = x1 + 1; i <= 3; i += 1){
				if (Board.getPiece(i, y1) instanceof Lasers){
					Board.winGame();
				}
				else if (Board.getPiece(i, y1) instanceof Mirrors){
					Mirrors piece = (Mirrors) Board.getPiece(i, y1);
					if (piece.orient == 1){
						shootVertical(i, y1, "down");
					}
					else if (piece.orient == 2){
						shootVertical(i, y1, "up");
					}
				}
			}
		}
	}
	
}

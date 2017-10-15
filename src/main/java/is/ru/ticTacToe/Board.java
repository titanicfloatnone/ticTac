package is.ru.tictactoe;

public class Board {

	private Square board[][];
	private boolean playersMove;
	private int movesPassed;

	public Board() {
		final int sizeOfBoard = 3;
		board = new Square[sizeOfBoard][sizeOfBoard];
		playersMove = false;
		movesPassed = 0;
	}


	public static void main(String[] args) {

	}
}

package is.ru.tictactoe;

public class Business {

	private Square[] board;
	private boolean xmove;
	private int moves;

	public Business() {
		board = new Square[9];
		for(int i = 0; i < 9; i++)
			board[i] = new Square();
		xmove = true;
		moves = 0;
	}

	public Square[] getBoard() {
		return board;
	}

	public int getMoves() {
		return moves;
	}

	public Square[] makeMove(int position) {
		if(position < 0 || position > 8) {
			throw new IllegalArgumentException("Illegal move!");
		}
		else if(!board[position].isFree()) {
			throw new IllegalArgumentException("Position taken!");
		}
		if(xmove) { 
			board[position].setSymbol('X');
			xmove = false;
		}
		else {
			board[position].setSymbol('O');
			xmove = true;
		}
		moves++;
		return board;
	}

	public boolean isTie() {
		if(moves == 9)
		{
			return true;
		}
		return false;
	}


	public static void main(String[] args) {

	}

	public boolean hasWinner() {

		boolean gameOver = false;
		for(int i = 0; i < 3; i++) {
			if(board[i*3].getSymbol() != ' ' && board[i*3].getSymbol() == board[i*3 + 1].getSymbol() && board[i*3 + 1].getSymbol() == board[i*3 + 2].getSymbol()) {

				gameOver = true;
			}
			if(board[i].getSymbol() != ' ' && board[i].getSymbol() == board[i+3].getSymbol() && board[i+3].getSymbol() == board[i+6].getSymbol()) {

				gameOver = true;
			}
		}
		if(board[0].getSymbol() != ' ' && board[0].getSymbol() == board[4].getSymbol() && board[4].getSymbol() == board[8].getSymbol()) {

			gameOver = true;
		}

		if(board[2].getSymbol() != ' ' && board[2].getSymbol() == board[4].getSymbol() && board[4].getSymbol() == board[6].getSymbol()) {

			gameOver = true;
		}
		return gameOver;
	}
}

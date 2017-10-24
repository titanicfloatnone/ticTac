package is.ru.tictactoe;

public class Business {

	private char[] board;
	private boolean xmove;

	public Business(){
		board = new char[9];
		xmove = true;
	}

	public char[] getBoard()
	{
		return board;
	}

	public void makeMove(int position)
	{
			board[position] = 'X';
			xmove = false;
	}

	public static void main(String[] args) {
		
	}
}




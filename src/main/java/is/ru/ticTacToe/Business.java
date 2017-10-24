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
		if(xmove)
		{	
			board[position] = 'X';
			xmove = false;
		}
		else
		{
			board[position] = 'O';
			xmove = true;
		}
	}

	public static void main(String[] args) {
		
	}
}




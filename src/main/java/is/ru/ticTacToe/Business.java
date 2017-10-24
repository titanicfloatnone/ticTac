package is.ru.tictactoe;

public class Business {

	private Square[] board;
	private boolean xmove;

	public Business(){
		board = new Square[9];
		for(int i = 0; i < 9; i++)
			board[i] = new Square();
		xmove = true;
	}

	public Square[] getBoard()
	{
		return board;
	}

	public void makeMove(int position)
	{
		if(position < 0 || position > 8){
			throw new IllegalArgumentException("Illegal move!");
		}
		else if(!board[position].isFree()){
			throw new IllegalArgumentException("Position taken!");
		}
		if(xmove){	
			board[position].setSymbol('X');
			xmove = false;
		}
		else{
			board[position].setSymbol('O');
			xmove = true;
		}
	}

	public static void main(String[] args) {
		
	}
}




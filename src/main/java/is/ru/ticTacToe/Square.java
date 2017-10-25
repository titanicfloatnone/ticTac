package is.ru.tictactoe;

public class Square {

    private char symbol;

    Square() {
        this.symbol = ' ';
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
    	this.symbol = symbol;
    }

    public boolean isFree() {
    	return this.symbol == ' ';
    }
}

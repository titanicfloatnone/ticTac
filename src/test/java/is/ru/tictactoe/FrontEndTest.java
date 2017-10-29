package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import com.google.gson.Gson;

public class FrontEndTest {

  @Test
  public void squareToJsonOriginalTest() {
    Business test = new Business();

    Square [] board  = new Square[9];
		for(int i = 0; i < 9; i++)
		  board[i] = new Square();

    Square input = new Square();
    input.setSymbol('X');
    board[1] = input;

    Gson gson = new Gson();
    String converted = gson.toJson(board);
    test.makeMove(1);
    assertEquals(converted, FrontEnd.squareToJson(test.getBoard()));
  }
}

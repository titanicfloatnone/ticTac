package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import com.google.gson.Gson;
import org.json.JSONArray;


public class FrontEndTest {

  @Test
  public void toJsonTest() {
    Business test = new Business();

    Square [] board  = new Square[9];
		for(int i = 0; i < 9; i++)
		  board[i] = new Square();

    Square input = new Square();
    input.setSymbol('X');
    board[1] = input;

    Gson gson = new Gson();
    JSONArray converted = gson.toJson(board);
    System.out.print(converted);
    assertEquals(converted, FrontEnd.squareToJson(test.makeMove(1)));
  }




}

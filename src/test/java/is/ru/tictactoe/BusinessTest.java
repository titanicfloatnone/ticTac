package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BusinessTest {
   
   @Test
   public void makeMoveMakeOneXMoveTest()
   {
   		Business test = new Business();
 		test.makeMove(7);
 		assertEquals('X', test.getBoard()[7]);
   }

}
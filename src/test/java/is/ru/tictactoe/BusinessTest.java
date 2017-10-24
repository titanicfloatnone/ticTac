package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BusinessTest {

   @Test
   public void hasWinnerEmptyBoardTest() {
   		Business test = new Business();
   		assertEquals(false, test.hasWinner());
   }
}
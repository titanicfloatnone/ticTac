package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BusinessTest {
   
   @Test
   public void makeMoveMakeOneXMoveTest()
   {
   		Business test = new Business();
 		test.makeMove(7);
 		assertEquals('X', test.getBoard()[7]);
   }

   @Test
   public void makeMoveMakeTwoMovesTest()
   {
   		Business test = new Business();
 		test.makeMove(7);
 		test.makeMove(6);
 		assertEquals('X', test.getBoard()[7]);
 		assertEquals('O', test.getBoard()[6]);
   }

   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Test
   public void makeMoveNegativePositionTest() throws IllegalArgumentException
   {
   		Business test = new Business();
   		thrown.expect(IllegalArgumentException.class);
   		thrown.expectMessage("Illegal move!");
   		test.makeMove(-1);
   }


}
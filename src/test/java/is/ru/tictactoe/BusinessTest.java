package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BusinessTest {

   @Test
   public void hasWinnerEmptyBoardTest() {
   		Business test = new Business();
   		assertEquals(false, test.hasWinner());
   }

   @Test
   public void hasWinnerThreeInARowHorizontalTest() {
   		Business test = new Business();
   		test.makeMove(3);
   		test.makeMove(1);
   		test.makeMove(4);
   		test.makeMove(2);
   		test.makeMove(5);
   		assertEquals(true, test.hasWinner());
   }

   @Test
   public void hasWinnerThreeInARowVerticalTest() {
   		Business test = new Business();
   		test.makeMove(1);
   		test.makeMove(0);
   		test.makeMove(4);
   		test.makeMove(2);
   		test.makeMove(7);
   		assertEquals(true, test.hasWinner());
   }

   @Test
   public void hasWinnerThreeInARowDiagonalFromTopLeftTest() {
   		Business test = new Business();
   		test.makeMove(0);
   		test.makeMove(1);
   		test.makeMove(4);
   		test.makeMove(2);
   		test.makeMove(8);
   		assertEquals(true, test.hasWinner());
   }

      @Test
   public void hasWinnerThreeInARowDiagonalFromTopRightTest() {
   		Business test = new Business();
   		test.makeMove(2);
   		test.makeMove(1);
   		test.makeMove(4);
   		test.makeMove(3);
   		test.makeMove(6);
   		assertEquals(true, test.hasWinner());
   }

   @Test
   public void makeMoveMakeOneXMoveTest()
   {
   		Business test = new Business();
 		test.makeMove(7);
 		assertEquals('X', test.getBoard()[7].getSymbol());
   }

   @Test
   public void makeMoveMakeTwoMovesTest()
   {
   		Business test = new Business();
 		test.makeMove(7);
 		test.makeMove(6);
 		assertEquals('X', test.getBoard()[7].getSymbol());
 		assertEquals('O', test.getBoard()[6].getSymbol());
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

   @Test
   public void makeMoveTooHighPositionTest() throws IllegalArgumentException
   {
   		Business test = new Business();
   		thrown.expect(IllegalArgumentException.class);
   		thrown.expectMessage("Illegal move!");
   		test.makeMove(9);
   }

   @Rule
   public ExpectedException thrown2 = ExpectedException.none();
   @Test
   public void makeMovePositionTakenTest() throws IllegalArgumentException
   {
   		Business test = new Business();
   		thrown2.expect(IllegalArgumentException.class);
   		thrown2.expectMessage("Position taken!");
   		test.makeMove(7);
   		test.makeMove(7);
   }

   @Test
   public void restartGameTest() {
      Business test = new Business();
      test.makeMove(1);
      assertEquals('X', test.getBoard()[1].getSymbol());
      test.restartGame();
      for(int i = 0; i < 9; i++)
        assertEquals(' ', test.getBoard()[i].getSymbol());
   }

   @Test
   public void restartAfterGameTest() {
      Business test = new Business();
      for(int i = 0; i < 9; i++)
        test.makeMove(i);
      test.restartGame();
      for(int i = 0; i < 9; i++)
        assertEquals(' ', test.getBoard()[i].getSymbol());
   }

}

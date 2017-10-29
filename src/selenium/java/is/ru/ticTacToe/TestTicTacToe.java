package is.ru.ticTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class TestTicTacToe extends SeleniumTestWrapper {
	
	@Test
  	public void testTitleMatches() {
		driver.get(baseUrl);
	    assertEquals("Tic Tac Toe", driver.getTitle());
	}

  	@Test
  	public void testXwinner() throws Exception {
	  	driver.get(baseUrl);
	  	Thread.sleep(2000);
	  	//WebElement restart = driver.findElement(By.id(""));
	  	WebElement input = driver.findElement(By.id("0"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("3"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("1"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("4"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("2"));
	  	input.click();
	  	Thread.sleep(2000);
	  	WebElement status = driver.findElement(By.id("winner-is"));
	  	Thread.sleep(3000);
	  	assertEquals("the winner is X!",status.getText());
  	}

	@Test
  	public void testOwinner() throws Exception {
  		driver.get(baseUrl);
  		Thread.sleep(2000);
  		WebElement input = driver.findElement(By.id("3"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("0"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("4"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("1"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("6"));
	  	input.click();
	  	Thread.sleep(2000);
	  	input = driver.findElement(By.id("2"));
	  	input.click();
	  	Thread.sleep(2000);
	  	WebElement status = driver.findElement(By.id("winner-is"));
	  	Thread.sleep(3000);
	  	assertEquals("the winner is O!",status.getText());
  	}


}
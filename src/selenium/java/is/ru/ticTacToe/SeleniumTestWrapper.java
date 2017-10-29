package is.ru.ticTacToe;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class SeleniumTestWrapper {

  static WebDriver driver;
  static DesiredCapabilities desiredCapabilities;
  static String baseUrl;

  @BeforeClass
  public static void openBrowser() {

    ChromeOptions chromeOptions = new ChromeOptions();
    DesiredCapabilities dc = DesiredCapabilities.chrome();

    chromeOptions.addArguments("--headless");

    dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    driver = new ChromeDriver(chromeOptions);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    baseUrl = "https://mighty-brushlands-46890.herokuapp.com";
  }

  @AfterClass
  public static void closeBrowser(){
    if(driver != null){
      driver.quit();
    }
    }
}

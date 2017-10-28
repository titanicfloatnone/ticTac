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
  //static ChromeDriver driver;
  static WebDriver driver;
  static DesiredCapabilities desiredCapabilities;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() {
    
    ChromeOptions chromeOptions = new ChromeOptions();
    DesiredCapabilities dc = DesiredCapabilities.chrome();
    //chromeOptions.setBinary("usr/bin/chromium-browser");
    chromeOptions.addArguments("--headless");

    dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    //driver = new RemoteWebDriver(dc);
    driver = new ChromeDriver(chromeOptions);


    //driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //port = System.getenv("PORT");
    /*if (port == null) {
        port = "4567";
    }*/
    baseUrl = "https://mighty-brushlands-46890.herokuapp.com"; /*+ port*/
  }

  @AfterClass
  public static void closeBrowser(){
    if(driver != null){
      driver.quit();
    }
    }
}

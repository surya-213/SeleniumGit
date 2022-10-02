package TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngDemo1 {
  WebDriver driver =null;

  @Parameters("browser")
  @BeforeTest
  public void setupTest(String browser){
    System.out.println("Thread ID for " +browser + "-> " + Thread.currentThread().getId());
    if(browser.equalsIgnoreCase("firefox")){
      System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("chrome")) {
      System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
      driver = new EdgeDriver();
    } else if (browser.equalsIgnoreCase("htmlunit")) {
      driver = new HtmlUnitDriver();
    }

  }

  @Test
  public void google(){
    driver.get("https://google.com");
    System.out.println(driver.getTitle());
  }

  @AfterTest
  public void tearDownTest(){
    driver.quit();
    System.out.println("Test completed successfully");
  }

}

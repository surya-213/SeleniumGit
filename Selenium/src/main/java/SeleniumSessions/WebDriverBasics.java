package SeleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");

    //launch FireFox
      WebDriver driver = new FirefoxDriver();


      driver.get("https://www.fb.com");
      System.out.println(driver.getTitle());

      driver.switchTo().newWindow(WindowType.WINDOW);

      driver.navigate().to("https://www.google.com");
      String title = driver.getTitle();
      if(title.equals("Google"))
      {
        System.out.println("correct title");
      }else{
        System.out.println("incorrect title");
      }

      driver.close();
      driver.switchTo().newWindow(WindowType.TAB);
      driver.navigate().to("https://www.google.com");
      driver.navigate().back();
      driver.navigate().forward();
      driver.navigate().refresh();
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("amazon");
      driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.ENTER);
      Thread.sleep(3000);

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0,400)");


      driver.findElement(By.xpath("//h3[contains(.,'Amazon.in')]")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple mobile");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    Thread.sleep(5000);
    List<WebElement> iPhoneNames = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[contains(@class,'s-list-col-right')]//span[contains(text(),'iPhone')]"));
    int i = 1;
    for (WebElement element : iPhoneNames){

        System.out.println(i++ + "->" +element.getText());
      }
    driver.quit();


  }


}

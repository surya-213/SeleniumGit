package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileHandlingNoClick {
  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");

    WebDriver driver = new FirefoxDriver();
    driver.get("https://html.com/input-type-file/");
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0,800)");

    driver.findElement(By.name("fileupload")).sendKeys("C:\\Users\\surya\\Downloads\\data-1663569607721.csv");
    driver.findElement(By.xpath("//input[@value='submit']")).click();
    driver.quit();
  }
}

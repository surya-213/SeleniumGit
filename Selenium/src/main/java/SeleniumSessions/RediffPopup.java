package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RediffPopup {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    driver.findElement(By.name("proceed")).click();
    Thread.sleep(2000);
    Alert alert = driver.switchTo().alert();
    if(alert.getText().equals("Please enter a valid user name")){
      System.out.println("correct pop up body");
    }else{
      System.out.println("incorrect pop up body");
    };
    alert.accept();
    driver.findElement(By.id("login1")).sendKeys("testing001");
    driver.findElement(By.id("login1")).sendKeys(Keys.ENTER);
    if(alert.getText().equals("Please enter your password")){
      System.out.println("correct pop up body");
    }else{
      System.out.println("incorrect pop up body");
    };
    driver.quit();
  }

}

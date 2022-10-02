package SeleniumSessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(
        "https://theautomationzone.blogspot.com/2022/08/dynamic-elements-synchronization.html");

    //element shown instantaneously
    driver.findElement(By.xpath("//button[text()='Show Message']")).click();
    driver.findElement(
        By.xpath("//p[text()='This message is shown immediately']")).click();
    String text = driver.findElement(
        By.xpath("//p[text()='This message is shown immediately']")).getText();
    System.out.println(text);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    //element shown after a delay
    driver.findElement(
        By.xpath("//button[text()='Show Message with small delay']")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//p[text()='This message is shown with small delay']"))).click();
    text = driver.findElement(
        By.xpath("//p[text()='This message is shown with small delay']")).getText();
    System.out.println(text);

    driver.findElement(
        By.xpath("//button[text()='Show Message with huge delay']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//p[text()='This message is shown with huge delay']"))).click();
    text = driver.findElement(
        By.xpath("//p[text()='This message is shown with huge delay']")).getText();
    System.out.println(text);

    driver.findElement(
        By.xpath("//button[text()='The button is enabled after a delay']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[text()='BUTTON']"))).click();
    text = driver.findElement(
        By.xpath("//p[text()='clicked after button is enabled']")).getText();
    System.out.println(text);

    driver.quit();
  }
}

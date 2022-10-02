package SeleniumSessions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RelativeLocators {
  public static void main(String[] args){
    System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();

    driver.get("https://theautomationzone.blogspot.com/2022/01/calculator.html");

    //locate single element with Relative locator
    String text = driver.findElement(RelativeLocator.with(By.tagName("input"))
        .below(By.xpath("//input[@value=2]"))
    ).getAttribute("value");
    System.out.println("found single element with Relative locator -> "+ text);
    //locate multiple elements with Relative locator
    List<WebElement> elements = driver.findElements(RelativeLocator.with(By.tagName("input"))
        .below(By.xpath("//input[@value=2]"))
    );
    System.out.println("Found multiple elements with Relative locator :");
    for (WebElement element : elements){
      System.out.println(element.getAttribute("value"));
    }
    driver.quit();

  }

}

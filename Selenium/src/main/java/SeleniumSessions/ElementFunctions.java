package SeleniumSessions;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import config.PropertiesFile;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementFunctions {

  public static String browser;
  static WebDriver driver;

  public static void main(String[] args){

    //set browser for test class
    PropertiesFile.readPropertiesFile();
    
    if(browser.equals("firefox")){
      System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
      driver = new FirefoxDriver();
      System.out.println("Running on firefox browser");
    } else if (browser.equals("headless-firefox")) {
      driver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
      System.out.println("Running on headless-firefox browser");
    } else if (browser.equals("headless-edge")) {
      driver = new HtmlUnitDriver();
      System.out.println("Running on headless-edge browser");
    } else if (browser.equals("htmlunit")) {
      driver = new HtmlUnitDriver();
      System.out.println("Running on htmlunit browser");
    }

    driver.get("https://theautomationzone.blogspot.com/2020/06/visibile-and-hidden-webelements.html");

    //Usage of isDisplayed()
    System.out.println("isDisplayed() -> " + driver.findElement(By.id("hide")).isDisplayed());
    driver.findElement(By.id("hide")).click();
    System.out.println("isDisplayed() -> " + driver.findElement(By.id("hide")).isDisplayed());

    //note 1 : (visibility:hidden) hides the element but it still takes up space in the layout
    //note 2 : (display:none) removes the element from the document and it does not take up any space

    //Usage of isEnabled()
    System.out.println("isEnabled() -> " + driver.findElement(By.id("button1")).isEnabled());
    System.out.println("isEnabled() -> " + driver.findElement(By.id("button2")).isEnabled());

    driver.get("https://theautomationzone.blogspot.com/2020/06/simple-checkbox-and-radio-buttons.html");

    //Usage of isSelected()
    System.out.println("isSelected() -> " + driver.findElement(By.id("myCheck")).isSelected());
    driver.findElement(By.id("myCheck")).click();
    System.out.println("isSelected() -> " + driver.findElement(By.id("myCheck")).isSelected());

    driver.get("https://theautomationzone.blogspot.com/2020/07/basic-dropdown.html");

    //Selecting in drop-down using Select class
    WebElement element = driver.findElement(By.id("mySelect"));
    Select select = new Select(element);

    select.selectByIndex(1);
    System.out.println("selected by Index -> " + select.getFirstSelectedOption().getText());
    select.selectByValue("pineapple");
    System.out.println("selected by value -> " + select.getFirstSelectedOption().getText());
    select.selectByVisibleText("Banana");
    System.out.println("selected by visible text -> " + select.getFirstSelectedOption().getText());

    //Selecting in multi-select drop-down with Select class
    WebElement element1 = driver.findElement(By.id("cars"));
    select = new Select(element1);

    select.selectByIndex(1);
    select.selectByIndex(2);
    select.selectByIndex(3);

    List<WebElement> listOfOptions = select.getAllSelectedOptions();
    System.out.println("Showing all selected options");
    for( WebElement element2 : listOfOptions){
      System.out.println(element2.getText());
    }

    driver.get("https://theautomationzone.blogspot.com/2020/07/mix-of-basic-webelements.html");

    //Note : getText() can ignore multiple lines and provided output in one line

    String text = driver.findElement(By.id("p1")).getText();
    System.out.println(text);

    //Note : getText() can ignore extra spaces with in line

    text = driver.findElement(By.id("p2")).getText();
    System.out.println(text);

    //Note : getText() can ignore insider tags of an element and print all the text

    text = driver.findElement(By.id("p3")).getText();
    System.out.println("span tag is ignored -> " + text);

    //getAttribute can fetch any html Attribute value
    //getAttribute("textContent") outputs text as it is in HTML code
    text = driver.findElement(By.id("p1")).getAttribute("textContent");
    System.out.println("p1 output with getAttribute(\"textContent\") -> " + text);

    text = driver.findElement(By.id("p2")).getAttribute("textContent");
    System.out.println("p2 outout with getAttribute(\"textContent\") -> " + text);

    //getAttribute("innerHTML") can print entire HTML code for the element

    text = driver.findElement(By.id("p3")).getAttribute("innerHTML");
    System.out.println("p3 output with getAttribute(\"innerHTML\") -> "+ text );

    //getAttribute("value") can output value of any input box or drop-down
    driver.findElement(By.id("input1")).sendKeys("selenium");
    text = driver.findElement(By.id("input1")).getAttribute("value");
    System.out.println("output with getAttribute(\"value\") -> " + text);

    driver.findElement(By.id("input1")).clear();
    driver.findElement(By.id("input1")).sendKeys("hello world");
    text = driver.findElement(By.id("input1")).getAttribute("value");
    System.out.println(text);

    text = driver.findElement(By.id("mySelect")).getAttribute("value");
    System.out.println(text);

    text = driver.findElement(By.id("link")).getAttribute("href");
    System.out.println("output with getAttribute(\"href\") -> " + text);

    driver.quit();
  }

}

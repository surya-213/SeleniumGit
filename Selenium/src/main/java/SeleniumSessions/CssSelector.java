package SeleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelector {
  public static void main(String[] args){
    System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");

    WebDriver driver = new FirefoxDriver();
    driver.get("https://theautomationzone.blogspot.com/2020/07/css-selector-practice.html");

    // find element with shortcut key "#" for Id
    String text = driver.findElement(By.cssSelector("#id1")).getText();
    System.out.println("found element with # shortcut-> " + text);

    // find element with shortcut key "." for class
    text = driver.findElement(By.cssSelector(".class1")).getText();
    System.out.println("found element with . shortcut-> " + text);
    text = driver.findElement(By.cssSelector("p.class2")).getText();
    System.out.println("found element with . shortcut->" + text);

    //find element with generic format tag[attribute=value]
    text = driver.findElement(By.cssSelector("p[id=id1]")).getText();
    System.out.println("found element with generic format -> " + text);
    text = driver.findElement(By.cssSelector("[name=name1]")).getText();
    System.out.println("found element with generic format -> " + text);

    //find element with combination of attributes
    text = driver.findElement(By.cssSelector("p[id=a][name=a]")).getText();
    System.out.println("found element with combination of attributes -> " + text);

    //find element using parent with > symbol
    text = driver.findElement(By.cssSelector("div[id=div1]>label[id='label']")).getText();
    System.out.println("found element using parent -> " + text);

    text = driver.findElement(By.cssSelector("div[id=div2]>label[id='label']")).getText();
    System.out.println("found element using parent -> " + text);

    //find descendant element using parent with (space)
    text = driver.findElement(By.cssSelector("div[id=div3] label[id='label']")).getText();
    System.out.println("found descendant element using parent -> " + text);

    //find element using starts with ^ symbol
    driver.findElement(By.xpath("//button[text()='random suffix']")).click();
    text = driver.findElement(By.cssSelector("p[id^='Class_AZ']")).getText();
    System.out.println("found element with start with ^ symbol -> " + text);

    // find element using ends with $ symbol
    driver.findElement(By.xpath("//button[text()='random prefix']")).click();
    text = driver.findElement(By.cssSelector("p[id$='Class_AZ']")).getText();
    System.out.println("found element with $ symbol -> " + text);

    //find element using contains * symbol
    driver.findElement(By.xpath("//button[text()='random id']")).click();
    text = driver.findElement(By.cssSelector("p[id*='Class_AZ']")).getText();
    System.out.println("found element with * symbol -> " + text);

    //find element using case insensitive symbol "i"
    driver.findElement(By.xpath("//button[text()='UPPER CASE id']")).click();
    text = driver.findElement(By.cssSelector("p[id='tommy' i]")).getText();
    System.out.println("found element with case insensitive symbol i -> " + text);

    //find element using first-of-type
    text = driver.findElement(By.cssSelector("div[id='Index']>b:first-of-type")).getText();
    System.out.println("found element with first:of:type -> " + text);

    //find element using last-of-type
    text = driver.findElement(By.cssSelector("div[id='Index']>b:last-of-type")).getText();
    System.out.println("found element with last-of-type -> " + text);

    //find element using nth-of-type
    text = driver.findElement(By.cssSelector("div[id='Index']>b:nth-of-type(3)")).getText();
    System.out.println("found element with nth-of-type -> " + text);

    //find element using nth-last-of-type
    text = driver.findElement(By.cssSelector("div[id='Index']>b:nth-last-of-type(3)")).getText();
    System.out.println("found element using nth-last-of-type -> " + text);

    //find element using only-of-type
    text = driver.findElement(By.cssSelector("div[class='only-of-type']>label:only-of-type")).getText();
    System.out.println("found element with only-of-type -> " + text);

    text = driver.findElement(By.cssSelector("div[class='only-of-type']>b:only-of-type")).getText();
    System.out.println("found element with only-of-type -> " + text);

    //find elements using first-child
    List<WebElement> elements = driver.findElements(By.cssSelector("div[id='divType'] b:first-child"));
    System.out.println("found elements using first-child : ");
    for(WebElement element : elements){
      System.out.println(element.getText());
    }

    // find elements using last-child
    elements = driver.findElements(By.cssSelector("div[id='divType'] b:last-child"));
    System.out.println("found elements using last-child : ");
    for(WebElement element : elements){
      System.out.println(element.getText());
    }

    //find elements using nth-child(n)
    elements = driver.findElements(By.cssSelector("div[id='divType'] b:nth-child(1)"));
    System.out.println("found elements using nth-child() : ");
    for(WebElement element : elements){
      System.out.println(element.getText());
    }

    //find elements using nth-last-child(n)
    elements = driver.findElements(By.cssSelector("div[id='divType'] b:nth-last-child(1)"));
    System.out.println("found elements using nth-last-child() : ");
    for (WebElement element : elements){
      System.out.println(element.getText());
    }

    //find elements using following siblings ~ symbol
    elements = driver.findElements(By.cssSelector("b~label"));
    System.out.println("found elements using following siblings ~ symbol :");
    for (WebElement element : elements){
      System.out.println(element.getText());
    }

    //find elements using directly following siblings + symbol
    elements = driver.findElements(By.cssSelector("b+label"));
    System.out.println("found elements using directly following siblings + symbol :");
    for (WebElement element : elements){
      System.out.println(element.getText());
    }

    driver.quit();
  }

}

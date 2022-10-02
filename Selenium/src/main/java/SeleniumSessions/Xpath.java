package SeleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xpath {

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");

    WebDriver driver = new FirefoxDriver();

    driver.get("https://theautomationzone.blogspot.com/2020/07/xpath-practice.html");

    // find element by ID
    String text = driver.findElement(By.id("id1")).getText();
    System.out.println("ID -> " + text);

    //find element by ID as XPATH
    String text1 = driver.findElement(By.xpath("//*[@id='id1']")).getText();
    System.out.println("ID as XPATH -> " + text1);

    // find element by name
    text = driver.findElement(By.name("name1")).getText();
    System.out.println("name -> " + text);

    //find element by name as XPATH
    text1 = driver.findElement(By.xpath("//*[@name='name1']")).getText();
    System.out.println("name as XPATH-> " + text1);

    //find element with any attribute
    text = driver.findElement(By.xpath("//*[@value='value1']")).getText();
    System.out.println("attribute (value) -> " + text);

    //find element with specific tag having common attributes
    text = driver.findElement(By.xpath("//p[@class='class1']")).getText();
    System.out.println("tag(p) with common attribute -> " + text);
    text1 = driver.findElement(By.xpath("//div[@class='class1']")).getText();
    System.out.println("tag(div) with common attribute -> " + text1);

    //find element by combining more than 1 attributes with "and"
    text = driver.findElement(By.xpath("//p[@id='a' and @name='a']")).getText();
    System.out.println("combined attributes -> " + text);
    text1 = driver.findElement(By.xpath("//p[@id='a' and @name='b']")).getText();
    System.out.println("combined attributes -> " + text1);

    //find element by text()
    text = driver.findElement(By.xpath("//p[text()='unique id']")).getText();
    System.out.println("text() -> " + text);

    //find parent node using child node with unique Identifier
    text = driver.findElement(By.xpath("//span[@id='link']/..")).getText();
    System.out.println("parent node found -> " + text);

    //find child node using parent node with unique Identifier
    driver.findElement(By.xpath("//div[@id='divA']/input")).sendKeys("test");
    driver.findElement(By.xpath("//div[@id='divC']//input")).sendKeys("test1");

    //find elements with index if no other option left
    text = driver.findElement(By.xpath("//p[@name='a'][2]")).getText();
    System.out.println("element with index -> " + text);
    text1 = driver.findElement(By.xpath("(//label[@id='lable'])[2]")).getText();
    System.out.println("element with index -> " + text1);

    //find parent node using unique Identifier of child (Advanced method)
    text = driver.findElement(By.xpath("//a[span[@id='link']]")).getText();
    System.out.println("Advanced parent node found method 1 -> " + text);

    //find parent node using unique Identifier of any child or grand-child (Advanced method)
    text1 = driver.findElement(By.xpath("//a[.//span[@id='link']]")).getText();
    System.out.println("Advanced parent node found method 2 -> " + text1);

    //find element using contains()
    driver.findElement(By.xpath("//button[text()='random']")).click();
    text = driver.findElement(By.xpath("//p[contains(text(),'has logged in successfully')]"))
        .getText();
    System.out.println("element found with contains() -> " + text);

    //find element using "starts-with"
    driver.findElement(By.xpath("//button[text()='change time']")).click();
    text = driver.findElement(By.xpath("//p[starts-with(text(),'logged in successfully')]"))
        .getText();
    System.out.println("found with starts-with -> " + text);

    driver.get("https://theautomationzone.blogspot.com/2020/07/sample-webtable-2.html");

    //find element using position()
    text = driver.findElement(
            By.xpath("//table[@id='table1']//tr[position()=1]/th[position()=1]"))
        .getText();
    System.out.println("found element with position() -> " + text);

    //find element using last()
    text = driver.findElement(
        By.xpath("//table[@id='table1']//tr[last()]/td[2]")).getText();
    System.out.println("found element using last() -> " + text);

    //find element using arithmatic operations
    text = driver.findElement(
        By.xpath("//table[@id='table1']//tr[last()-1]/td[2]")
    ).getText();
    System.out.println("found element with position() -> " + text);
    text = driver.findElement(
        By.xpath("//table[@id='table1']//tr[last()-1]/td[2+1]")
    ).getText();
    System.out.println("found element with position() -> " + text);

    //find element with count()
    text = driver.findElement(By.xpath("//table[count(.//tr)=6]")).getText();
    System.out.println("found element with count() -> " + "\n" + text);

    driver.get("https://theautomationzone.blogspot.com/2020/07/xpath-practice.html");

    //remove spaces using normalize-space
    driver.findElement(By.xpath("//button[text()='No Space']")).click();
    driver.findElement(By.xpath("//button[text()='Preceding Space']")).click();
    text = driver.findElement(
        By.xpath("//p[normalize-space(text()) = 'Tommy']")
    ).getText();
    System.out.println("preceding spaces removed with normalize-space -> " + text);
    driver.findElement(By.xpath("//button[text()='Trailing Space']")).click();
    text1 = driver.findElement(By.xpath("//p[normalize-space(text())='Tommy']")).getText();
    System.out.println("Trailing spaces removed with normalize-space -> " + text1);
    driver.findElement(By.xpath("//button[text()='Preceding And Trailing Space']")).click();
    String text2 = driver.findElement(By.xpath("//p[normalize-space(text())='Tommy']")).getText();
    System.out.println("Preceding And Trailing Space removed with normalize-space -> " + text2);

    //replace characters using translate()
    String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    driver.findElement(By.xpath("//button[text()='lower case']")).click();
    text = driver.findElement(By.xpath("//p[translate(text(),'"+lowerCase+"','"+upperCase+"')='TOMMY']")).getText();
    System.out.println("element found with translate() -> " + text);

    // find elements with string-length
    List<WebElement> elements = driver.findElements(By.xpath("//p[string-length(text()) >30]"));
    System.out.println(elements.size() + " elements found with string-length");

    //element can also be found with round() by rounding off a decimal number
    //element can also be found with floor() by rounding off to lowest integer value

    //find element with not()
    driver.findElement(By.xpath("//input[@type='radio' and not(@id='gender-0')]")).click();
    if(driver.findElement(By.xpath("//input[@type='radio' and not(@id='gender-0')]")).isSelected()){
      System.out.println("found element with not()");
    }

    //find element with substring-before()
    driver.findElement(By.xpath("//button[text()='change time']")).click();
    text = driver.findElement(By.xpath("//p[substring-before(text(),':') = 'logged in successfully ']")).getText();
    System.out.println("found element with substring-before() -> " + text);

    //find element with substring-after()
    text1 = driver.findElement(By.xpath("//p[contains(substring-after(text(),'logged'),'am') or contains(substring-after(text(),'logged'),'pm')]")).getText();
    System.out.println("found element with substring-after() -> " + text1);

    //find element with parent tag
    List<WebElement> parentElements = driver.findElements(By.xpath("//div[@id='Y2']/parent::*"));
    System.out.println(parentElements.size() + " element found with parent tag");

    //find element with ancestor tag
    List<WebElement> ancestorElements = driver.findElements(By.xpath("//div[@id='Y2']/ancestor::*"));
    System.out.println(ancestorElements.size() + " elements found with ancestor tag");
    ancestorElements = driver.findElements(By.xpath("//div[@id='Y2']/ancestor::div[@id='A']"));
    System.out.println(ancestorElements.size() + " element found with ancestor tag");

    //find element with child tag
    List<WebElement> childElements = driver.findElements(By.xpath("//div[@id='B2']/child::*"));
    System.out.println(childElements.size() + " elements found with child tag");

    //find element with descendent tag
    List<WebElement> descendentElements = driver.findElements(By.xpath("//div[@id='B2']/descendant::*"));
    System.out.println(descendentElements.size() + " elements found with descendent tag");

    //find elements with following tag
    List<WebElement> followingElements = driver.findElements(By.xpath("//div[@id='B2']/following::*"));
    System.out.println(followingElements.size() + " elements found with following tag");

    //find elements with following-sibling tag
    List<WebElement> followingSiblingElements = driver.findElements(By.xpath("//div[@id='B2']/following-sibling::*"));
    System.out.println(followingSiblingElements.size() + " elements found with following-sibling tag");

    //find elements with preceding tag
    List<WebElement> precedingElements = driver.findElements(By.xpath("//div[@id='B2']/preceding::*"));
    System.out.println(precedingElements.size() + " elements found with preceding tag");

    //find elements with preceding-sibling tag
    List<WebElement> precedingSiblingElements = driver.findElements(By.xpath("//div[@id='B2']/preceding-sibling::*"));
    System.out.println(precedingSiblingElements.size() + " elements found with preceding-sibling tag");

    //find element example
    driver.findElement(By.xpath("//label[text()='Name']/following-sibling::div/input")).sendKeys("Surya");
    driver.findElement((By.xpath("//label[text()='Father']/following-sibling::div/input"))).sendKeys("Father");
    driver.findElement(By.xpath("//label[text()='Mother']/following-sibling::div/input")).sendKeys("Mother");

    try{}
    finally {
      driver.quit();
    }
  }
}

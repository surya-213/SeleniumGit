package TestNGDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
public class log4j {
  private static Logger logger = LogManager.getLogger(log4j.class);
  static{

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    System.setProperty("current.date.time", dateFormat.format(new Date()));
  }

  @Test
  public void test1() {
    System.out.println("Hello world");

    logger.info("this is info");
    logger.warn("this is warn");
    logger.error("this is error");
    logger.fatal("this is fatal");
    System.out.println(System.getProperty("current.date.time"));

    System.out.println("completed");
  }
  @Test
  public void test2(){
    System.out.println("Inside Test2");
    Assert.assertTrue(false);
  }
  @Test
  public void test3(){
    System.out.println("Inside Test3");
    throw new SkipException("This test");
  }

}

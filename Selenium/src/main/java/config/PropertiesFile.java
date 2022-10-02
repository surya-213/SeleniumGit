package config;

import SeleniumSessions.ElementFunctions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
  static Properties prop = new Properties();

  public static void main(String[] args) {
    readPropertiesFile();
    writePropertiesFile();
    readPropertiesFile();
  }

  public static void readPropertiesFile() {
    InputStream input = null;
    try {
      input = new FileInputStream("src/main/java/config/config.properties");
      prop.load(input);

      //set browser for test class
      ElementFunctions.browser = prop.getProperty("browser");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void writePropertiesFile(){
    try{
      OutputStream output = new FileOutputStream("src/config/config.properties");
      prop.setProperty("browser","chrome");
      prop.store(output,null);
    }catch (Exception e){
      e.printStackTrace();
    }

  }
}

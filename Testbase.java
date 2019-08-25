package webstaurantstore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testbase {
	
	public static WebDriver driver=null;	
	public static Properties prop=null;
	
	public Testbase() throws IOException {
		//create an object for Properties class
		prop=new Properties();
		 //read the config Properties file
		try {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\webstaurantstore\\config\\config.properties");
		
		//load all the properties
		prop.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initwebdriver() {
		//launch the browser
		  System.setProperty("webdriver.chrome.driver","D:\\browserexe\\Chrome\\chromedriver.exe");
		  driver=new ChromeDriver();	   
	     
	   //add implicit wait
	     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   
	   //maximize the window
	     driver.manage().window().maximize();
	   
	    driver.get(prop.getProperty("url"));
	   //1.Open Chrome to www.webstaurantstore.com
	     //driver.get("https://www.webstaurantstore.com");
	  
	  
	}

}

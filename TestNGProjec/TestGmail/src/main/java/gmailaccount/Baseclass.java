
package gmailaccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Baseclass {
	public static WebDriver driver= null;
 
 public static Properties prop;
 public static WebDriverWait wait=null;
 
 public void property()  {
	 try {
	 prop=new Properties();
	FileInputStream	ip = new FileInputStream("C:\\corejavasripts\\TestGmail\\config.properties");
	prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 }
 
 
 public static void initialization() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,20);
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
 }
	public  static void failed(String testmethodname) {
 try {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
			File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File("C:\\corejavasripts\\TestGmail\\screenshot\\testfailure"+""+"testmethodname"+".jpg");
			FileHandler.copy(srcfile, destfile);
	} 
	 catch (Exception e) {
		
		System.out.println("Exception while taking screenshot "+e.getMessage());
		
	 }
	 
 }
}

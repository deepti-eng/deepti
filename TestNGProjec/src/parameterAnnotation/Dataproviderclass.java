package parameterAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderclass {
	@DataProvider(name= "checkout")
	
	public static Object[][] formfields(){
		return new Object[][] {{"Deepti","deepti"},{"DEEPTI","AGGARWAL"}};
	}
	
  @Test(dataProvider = "checkout")
  public void  Test(String fname,String lname) throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.sheercover.com/order");
	  
	  WebElement checkout = driver.findElement(By.xpath("//a[@class='checkout checkout-e ctracking']"));
	  checkout.click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_firstName']"));
	  driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_lastName']"));
  }
  }


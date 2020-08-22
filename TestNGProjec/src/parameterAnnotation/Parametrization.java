package parameterAnnotation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Parametrization {
	 public WebDriver driver;
	
	
	@Test
	@Parameters({"email","phone","firstname"})
  public void enterbillinginfo(String email, String phone, String firstname) throws Exception{
		WebElement checkout = driver.findElement(By.xpath("//a[@class='checkout checkout-e ctracking']"));
		
		checkout.click();
		Thread.sleep(3000);
		
		WebElement email1 = driver.findElement(By.xpath("//input[@id='dwfrm_personinf_contact_email']"));
		email1.sendKeys(email);
		
		WebElement phone1 = driver.findElement(By.xpath("//input[@id='dwfrm_personinf_contact_daytimephone']"));
		phone1.sendKeys(phone);
		
		WebElement firstname1= driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_firstName']"));
		
		firstname1.sendKeys(firstname);

		
		
  }
  @BeforeClass
  public void launchsite() {
	  System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://www.sheercover.com/order");
	  
  }

  @AfterClass
  public void closebrowser() {
	  driver.close();
  }

}

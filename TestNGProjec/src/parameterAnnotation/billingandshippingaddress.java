package parameterAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class billingandshippingaddress {
	@DataProvider(name="StagingBillingAddress")
	public static Object[][] sameAsBilling(){
		return new Object[][] {{"StagingBillingfirstName","StagingbillingLastName"}};
		
	}
	
	@DataProvider(name="StagingShippingAddress")
	public static Object[][] differentbilling(){
		return new Object[][] {{"StagingbillingfirstName", "StagingBillingLastName","StagingShippingFirstName","StagingShippingLastName"}};
	}
	
  @Test(priority=0,dataProvider="StagingBillingAddress")
  public void billingAddress(String billFname,String BillLastName) throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.sheercover.com/order");
	  
	 
	  WebElement checkout = driver.findElement(By.xpath("//a[contains(@class,'buttons-next next-page section-checkout')]"));
 checkout.click();
 Thread.sleep(3000);
 
 WebElement firstName = driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_firstName']"));
  firstName.sendKeys(billFname);
  
  System.out.println(firstName.getAttribute("Value"));
  driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_lastName']")).sendKeys(BillLastName);
   driver.quit();
  }
		  
		  @Test(priority=1,dataProvider="StagingShippingAddress")
  public void shippingAddress(String billfname,String billLastName,String shipFirstName, String shipLastName) throws Exception  {
  
  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); 
  WebDriver driver = new ChromeDriver();
  driver.get("http://www.sheercover.com/order");
  
  WebElement checkout = driver.findElement(By.xpath("//a[@class='checkout checkout-e ctracking']"));
  checkout.click();
  Thread.sleep(2000);
  WebElement firstName = driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_firstName']"));
  firstName.sendKeys(billfname);
  
  //System.out.println(firstName.getAttribute("value"));
  
  driver.findElement(By.xpath("//input[@id='dwfrm_personinf_billtoaddress_lastName']")).sendKeys(billLastName);
  //un check ship to billing address checkbox
  driver.findElement(By.xpath("//input[@id='dwfrm_personinf_useAsBillingAddress']")).click();
  
  driver.findElement(By.xpath("//input[@id='dwfrm_personinf_shipptoaddress_firstName']")).sendKeys(shipFirstName);
   driver.findElement(By.xpath("//input[@id='dwfrm_personinf_shipptoaddress_lastName']")).sendKeys(shipLastName);
}
}

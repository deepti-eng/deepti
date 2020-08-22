package gmailtestcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import gmailaccount.Baseclass;

@Listeners(Customlistener.class)
public class failedtestcasesscreenshot  extends Baseclass{

	 @BeforeTest
		public void readpropertyFile() {
			 property();
		} 

	
  @Test(priority=1)	
  
  public void setup() {
	  initialization();
				 
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/testgmail.html");
				  
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	ExtentTest logger = extent.createTest("setup");
	
	logger.log(Status.INFO, "Login to gmail");
	extent.flush();
	
  }
	  
	 @Test(priority=2)
	public void createAC() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='NlWrkb snByac']")));
	WebElement createAc = driver.findElement(By.xpath("//span[@class='NlWrkb snByac']"));
					
	createAc.click();
	 
	WebElement myself = driver.findElement(By.xpath("//span[@class='z80M1 G3hhxb'and @aria-label='For myself']"));
	myself.click();
	
	System.out.println("user is able to click on myself link");
	
	 }
	 
	
	
	@Test(priority =3)	
			public void names() {	
	WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
	firstname.sendKeys(prop.getProperty("first_name"));
	WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
	lastname.sendKeys(prop.getProperty("last_name"));
	}
				
		@Test(priority=4)
		public void username() {
	WebElement username = driver.findElement(By.xpath("//input[@name='Username']"));
	username.sendKeys("edewjkdn");
			
	WebElement password = driver.findElement(By.xpath("//input[@name='Passwd']"));
		password.sendKeys("free123");
		
	WebElement  confpassword = driver.findElement(By.xpath("//input[@name='ConfirmPasswd']"));
		confpassword.sendKeys("free123");
		
	WebElement  next = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		next.click();
		
		}
		
		@AfterTest
		public void teardown() {
			driver.quit();
		}
	}




package Twitter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.Base;
import pomclasstwitter.HomePageTweeter;
import pomclasstwitter.LogInPage;

public class VerifyExploreFunctionalityAndSearchTab {
    
	WebDriver driver;
	LogInPage loginpage;
	HomePageTweeter homepagetwitter;
	SoftAssert soft;
	
	@Parameters ("browserName")
	
    @BeforeTest
		public void launchBrowser(String browser)
		
		{	
			if(browser.equals("Chrome"))
		   {
			driver=Base.openChromebrowser();
		   }
		   if(browser.equals("Edge"))
		   {
			driver=Base.openMicrosoftEdge();
		   }
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  
		} 
	@BeforeClass()
	public void BrowserLaunch()
	{
		loginpage=new LogInPage(driver);
		homepagetwitter=new HomePageTweeter(driver);
	}
	@BeforeMethod
	public void logIntoTheApplication() throws InterruptedException
	{
		driver.get("https://twitter.com/i/flow/login");
		driver.manage().window().maximize();
	    Thread.sleep(2000);
		loginpage.logIntoTwitter();
		Thread.sleep(3000);
		
		
	}
	@Test
	public void verifyexploreButtonAndSearchTabWithUserName() throws InterruptedException
	{   
		soft=new SoftAssert();
		homepagetwitter.clickonexplorebutton(); 
		Thread.sleep(2000);
		homepagetwitter.clickonfourthelement();
		Thread.sleep(2000);
		String url1=driver.getCurrentUrl();
	    String title1=driver.getTitle();
	
		Assert.assertEquals("https://twitter.com/Cristiano", url1);
		soft.assertEquals("Cristiano Ronaldo (@Cristiano) / Twitter", title1);
//		   if(url1.equals("https://twitter.com/Cristiano")&& title1.equals("Cristiano Ronaldo (@Cristiano) / Twitter"))
//		   {
//			   System.out.println("test case pass");
//		   }
//		   else
//		   {
//			   System.out.println("test case fail");
//		   }          
		   
	}
	
	@AfterMethod
	public void LogOutFromApplication() throws InterruptedException
	{ 
		Thread.sleep(2000);
		homepagetwitter.logOutFromTwitter();
	}
	@AfterClass
	public void browserClose()
	{
		loginpage=null;
		homepagetwitter=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
		driver=null;
		System.gc(); 
	}
}

	
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

public class VerifyTweetButtonAndFinalTweetButton {

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
	public void VerifyTweetButtonAndFinalT() throws InterruptedException
	{   
		  soft=new SoftAssert();        
		   homepagetwitter.TweetButton();
		   Thread.sleep(2000);
		   String url0=driver.getCurrentUrl();
		   String title0=driver.getTitle();
		  Assert.assertEquals("https://twitter.com/compose/tweet", url0);
		  soft.assertEquals("Home / Twitter", title0);
		   
//		   if(url0.equals("https://twitter.com/compose/tweet")&& title0.equals("Home / Twitter"))
//		   {
//			   System.out.println("test case pass");
//		   }
//		   else
//		   {
//			   System.out.println("test case fail");
//		   }
//		   
		   homepagetwitter.Tetxinput();
		   Thread.sleep(2000);
		   homepagetwitter.TweetButtonFinal();
		   Thread.sleep(3000);
		   String url1=driver.getCurrentUrl();
		   String title1=driver.getTitle();
		Assert.assertEquals("https://twitter.com/home", url1);
		soft.assertEquals("Home / Twitter", title1);
		soft.assertAll();
//		   if(url1.equals("https://twitter.com/home")&& title1.equals("Home / Twitter"))
//		   {
//			   System.out.println("test case pass");
//		   }
//		   else
//		   {
//			   System.out.println("test case fail");
//		   }
//		   
		   homepagetwitter.threeDotClickforDeletT();

	}
	
	
	@AfterMethod
	public void LogOutFromApplication() throws InterruptedException
	{
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

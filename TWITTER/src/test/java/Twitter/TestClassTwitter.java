package Twitter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomclasstwitter.HomePageTweeter;
import pomclasstwitter.LogInPage;

public class TestClassTwitter {

	public static void main(String[] args) throws InterruptedException {
		
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\91775\\Downloads\\chromedriver_win32\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   driver.get("https://twitter.com/i/flow/login");
	   driver.manage().window().maximize();
	   Thread.sleep(2000);
	   
	   LogInPage loginpage=new LogInPage(driver);
	   Thread.sleep(2000);
	   loginpage.logIntoTwitter();
	   Thread.sleep(3000);
	   
	   HomePageTweeter homepagetwitter=new HomePageTweeter(driver);            //logout

//	   homepagetwitter.TweetButton();
//	   Thread.sleep(2000);
//	   String url0=driver.getCurrentUrl();
//	   String title0=driver.getTitle();
//	  
//	   if(url0.equals("https://twitter.com/compose/tweet")&& title0.equals("Home / Twitter"))
//	   {
//		   System.out.println("test case pass");
//	   }
//	   else
//	   {
//		   System.out.println("test case fail");
//	   }
//	   
//	   homepagetwitter.Tetxinput();
//	   Thread.sleep(2000);
//	   homepagetwitter.TweetButtonFinal();
//	   Thread.sleep(3000);
//	   String url1=driver.getCurrentUrl();
//	   String title1=driver.getTitle();
//	
//	   if(url1.equals("https://twitter.com/home")&& title1.equals("Home / Twitter"))
//	   {
//		   System.out.println("test case pass");
//	   }
//	   else
//	   {
//		   System.out.println("test case fail");
//	   }
//	   
//	   homepagetwitter.threeDotClickforDeletT();
//	   homepagetwitter.logOutFromTwitter();
	   homepagetwitter.clickonexplorebutton(); 
	   Thread.sleep(2000);
	   homepagetwitter.clickonfourthelement();
	   Thread.sleep(2000);
	   String url1=driver.getCurrentUrl();
	   String title1=driver.getTitle();
	   System.out.println(url1);
	   System.out.println(title1);
	   if(url1.equals("https://twitter.com/Cristiano")&& title1.equals("Cristiano Ronaldo (@Cristiano) / Twitter"))
	   {
		   System.out.println("test case pass");
	   }
	   else
	   {
		   System.out.println("test case fail");
	   }
	   ///SDFKSDLSLSLKF
	   
	}
}

package pomclasstwitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTweeter {

	@FindBy(xpath="(//div[@role='button'])[4]")
	private WebElement Myprofile3dotbutton;
	
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-16y2uox r-1wbh5a2'])[2]")
	private WebElement ClickonLogOutUser;
	
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement finalLogout;
	
	@FindBy(xpath="//a[@aria-label='Tweet']")
	private WebElement tweet;
	
	@FindBy(xpath="//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	private WebElement whatshappeningbox;
	
	@FindBy(xpath="//span[text()='Tweet']")
	private WebElement finaltweet;
	
	@FindBy(xpath="(//div[@aria-label='More'])[1]")
	private WebElement delet3dotclick;
	
	@FindBy(xpath="//span[text()='Delete']")
	private WebElement clickondelete;
	
	@FindBy(xpath="//span[text()='Delete']")
	private WebElement confirmdelete;
	
	@FindBy(xpath="	(//div[@class='css-1dbjc4n'])[3]")
	private WebElement exploreelement;

	@FindBy(xpath="//input[@aria-label='Search query']")
	private WebElement Searchelement;
	@FindBy(xpath="(//div[@data-testid='typeaheadResult'])[4]")
	private WebElement select4thelement;
	
	
	public HomePageTweeter(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logOutFromTwitter() throws InterruptedException 
	{
		Myprofile3dotbutton.click();
		Thread.sleep(1500);
		ClickonLogOutUser.click();
		Thread.sleep(1500);
		finalLogout.click();
    }
	
	public void TweetButton() throws InterruptedException 
	{
		tweet.click();
		Thread.sleep(2500);
	
    }
	public void Tetxinput() throws InterruptedException 
	{
		
		whatshappeningbox.sendKeys("zhukega nahi");
		
    }
	public void TweetButtonFinal() throws InterruptedException 
	{
		
		finaltweet.click();
    }
	public void threeDotClickforDeletT() throws InterruptedException 
	{
		
		delet3dotclick.click();
		clickondelete.click();
		confirmdelete.click();
    }
	public void clickonexplorebutton() throws InterruptedException 
	{
		exploreelement.click();
		Thread.sleep(1500);
		Searchelement.sendKeys("Cristiano Ronaldo");
		
    }	
	
	public void clickonfourthelement() throws InterruptedException 
	{
		Thread.sleep(1500);
		select4thelement.click();
    }	


}

package pomclasstwitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	@FindBy(xpath="//div[@class='css-1dbjc4n r-16y2uox r-1wbh5a2']//div//input")
	private WebElement email;
	
	@FindBy(xpath="(//div[@dir='auto'])[7]")
	private WebElement nextbutton;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-mk0yit r-1f1sjgu']//div//input")
	private WebElement password;
	
	@FindBy(xpath="(//div[@dir='auto'])[7]")
	private WebElement nextbutton2;
	
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void logIntoTwitter() throws InterruptedException 
	{
	email.sendKeys("7756081931");
	nextbutton.click();
	Thread.sleep(1000);
	password.sendKeys("Endless@1310");
	nextbutton2.click();
//endless 
}
}

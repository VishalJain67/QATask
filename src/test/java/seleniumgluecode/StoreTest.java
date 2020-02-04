package seleniumgluecode;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StoreTest {

	public static WebDriver driver;
	
	@Given("^user is on page which lists the pillow to be purchased$")
	public void user_is_on_page_which_lists_the_pillow_to_be_purchased() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","/Users/E082978/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.midtrans.com/");
        driver.manage().window().maximize();
		
	}

	@When("^user clicks on Buy Now and is taken to Payment page$")
	public void user_clicks_on_Buy_Now_and_is_taken_to_Payment_page() throws Throwable {
	    
		driver.findElement(By.xpath("//*[@class='btn buy']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//*[@class='cart-checkout']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
		WebElement element = driver.findElement(By.xpath("//*[@class='button-main show']"));
		
	       Robot robot = new Robot();
	       Thread.sleep(2000);
	       robot.keyPress(KeyEvent.VK_TAB);
	       Thread.sleep(2000);
	       robot.keyPress(KeyEvent.VK_TAB);
	       Thread.sleep(2000);
	       robot.keyPress(KeyEvent.VK_ENTER);
	       
		
		//driver.findElement(By.linkText("Continue")).click();
		
	/*	WebElement element = driver.findElement(By.xpath("//*[@class='button-main show']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);*/
        
        
		//driver.findElement(By.xpath("//*[@class='text-button-main']")).click();
		//String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		/*for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.findElement(By.xpath("//*[@class='text-button-main']")).click();
		}*/
		
		//driver.switchTo().alert().accept();
		
	}

	@When("^user selects Credit card as payment option, enters card details and proceeds with payment$")
	public void user_selects_Credit_card_as_payment_option_enters_card_details_and_proceeds_with_payment() throws Throwable {
	
		driver.findElement(By.xpath("//div[text()='Credit Card']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@name='cardnumber']")).sendKeys("4811 1111 1111 1114");
		driver.findElement(By.xpath("//*[text()='Expiry date']")).sendKeys("02/20");
		driver.findElement(By.xpath("//*[text()='CVV']")).sendKeys("123");
		driver.findElement(By.xpath("//*[@class='text-button-main']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enters the card otp and clicks on pay$")
	public void user_enters_the_card_otp_and_clicks_on_pay() throws Throwable {
		
		driver.findElement(By.xpath("//*[@class='form-control input-xs']")).sendKeys("112233");
		driver.findElement(By.xpath("//*[@class='btn btn-sm btn-success']")).click();
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		
		driver.findElement(By.xpath("//*[text()='Transaction successful']")).isDisplayed();
	}

}

package webstaurantstore.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import webstaurantstore.base.Testbase;

public class Homepage extends Testbase {

	public WebDriverWait wait = new WebDriverWait(driver, 30);

	public Homepage() throws IOException {
		super();

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "searchval")
	WebElement search_edit_box;
	@FindBy(xpath = "//input[@type='submit' and @value='Search']")
	WebElement search_button;
	@FindBy(xpath = "//input[contains(@value,'Add to Cart')]")
	WebElement add_to_cart_button;
	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	WebElement cart;
	@FindBy(xpath = "//a[contains(@title,'Pre-Seasoned Mini Cast Iron Round Casserole Dish')]")
	WebElement cart_msg;
	@FindBy(xpath = "//a[contains(text(),'Empty Cart')]")
	WebElement empty_cart;
	@FindBy(xpath = "//*[@type='button' and @class='btn btn-primary']")
	WebElement popup_empty_cartbutton;
	String expTitle = "WebstaurantStore: Restaurant Supplies & Foodservice Equipment";

	// add Explicit wait
	public void verifyHomePageTitle() {

		wait.until(ExpectedConditions.titleContains(expTitle));
		Assert.assertEquals(getwebstauranttitle(), expTitle);
	}

	public String getwebstauranttitle() {
		return driver.getTitle();
	}

	public void searchbutton() {
		// 2.Enter 825CI25MS into the Search Field
		search_edit_box.clear();
		search_edit_box.sendKeys("825CI25MS");

		// 3.click the Search button
		search_button.click();

		// 4.Verify that the search result opens to “Valor 25 oz. Pre-Seasoned Cast Iron
		// Round Server - 12/Pack”
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Pre-Seasoned Mini')]")));
		Assert.assertEquals(driver.getTitle(),
				"Valor 25 oz. Pre-Seasoned Mini Cast Iron Round Casserole Dish - 12/Case");

	}

	public void addtocart() throws InterruptedException, IOException, AWTException {

		// 5.Click Add to Cart
		add_to_cart_button.click();

		// 6. Click the Cart button
		cart.click();

		// 7.Verify “Valor 25 oz. Pre-Seasoned Cast Iron Round Server - 12/Pack” is in
		// the cart
		wait.until(ExpectedConditions.visibilityOf(cart_msg));

		// 8.Click Empty Cart
		empty_cart.click();

		Robot robot = new Robot();
		Thread.sleep(3000);
		// Doing a mouse over for the X and Y coordinates of button/link which opens
		// modal window
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		robot.mouseMove(300, 150);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		// verifying the weather cart is empty or not. After clicking empty cart
		// button*/
		WebElement emptyele = driver.findElement(By.xpath("//*[@class='cartEmpty box padded']"));
		wait.until(ExpectedConditions.visibilityOf(emptyele));
		highLightElement(driver, emptyele);
	}

	public void highLightElement(WebDriver driver, WebElement element) throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:solid 5px red')", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].setAttribute('style','border:solid 2px white')", element);

	}
}

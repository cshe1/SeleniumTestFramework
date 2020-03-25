package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author CoryZ
 * Amazon home page objects and locators for method steps.
 */
public class AmazonHomeObjects {

	WebDriver driver;
	static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\AmazonReportResults.html", true);;
	static ExtentTest test = report.startTest("ExtentDemo");

	//Constructor for WebDriver
	public AmazonHomeObjects(WebDriver driver) {
		this.driver= driver;
	}

	//Locators
	static By txtbox_search = By.xpath("//*[@id = 'twotabsearchtextbox' and @type ='text']");
	static By firstResult = By.xpath("//*[@class = 's-image' and @data-image-index = '0']");
	static By secondResult = By.xpath("//*[@class = 's-image' and @data-image-index = '1']");
	static By addToCart = By.xpath("//*[@id = 'add-to-cart-button']");
	static By emptyCart = By.xpath("//*[@id = 'nav-cart-count']");

	/**
	 * @author CoryZ
	 * Below are methods for Amazon page navigation
	 */
	
	//Method that sends user input into the Amazon search bar
	public void search(String searchText) {
		driver.findElement(txtbox_search).clear();
		driver.findElement(txtbox_search).sendKeys(searchText);		
	}
	
	//Method that submits whatever is written in the search bar. Will fail if search bar is empty.
	public void returnSearch() {
		driver.findElement(txtbox_search).submit();
		String sum = driver.findElement(txtbox_search).getAttribute("value");
		if (!sum.isEmpty()) {
			test.log(LogStatus.PASS, "Search bar functioning");
		}else {
			test.log(LogStatus.FAIL, "Search bar is empty");
		}
	}
	
	//Method that will click the first product in a returned Amazon search
	public void clickResult() {
		driver.findElement(firstResult).click();
	}
	
	//Method to click on the add to cart button
	public void addToCart() {
		driver.findElement(addToCart).click();
	}

	//Method that verifies that the cart is not empty. If it is found empty, step will fail
	public void verifyCartNotEmpty() {
		String empty = driver.findElement(emptyCart).getAttribute("class");
		
		if(empty.equalsIgnoreCase("nav-cart-count nav-cart-0")) {
			test.log(LogStatus.FAIL, "Amazon Cart is empty");
		}else {
			test.log(LogStatus.PASS, "Cart contains items");
		}
	}

	public void flushTest() {
		report.endTest(test);
		report.flush();
	}
}

package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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

	//Methods for Amazon
	public void search(String searchText) {
		driver.findElement(txtbox_search).clear();
		driver.findElement(txtbox_search).sendKeys(searchText);		
	}

	public void returnSearch() {
		driver.findElement(txtbox_search).submit();
		String sum = driver.findElement(txtbox_search).getAttribute("value");
		if (!sum.isEmpty()) {
			test.log(LogStatus.PASS, "Search bar functioning");
		}else {
			test.log(LogStatus.FAIL, "Search bar is empty");
		}
	}
	
	public void clickResult() {
		driver.findElement(firstResult).click();
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}

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

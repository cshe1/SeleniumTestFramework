package webpages;

/**
 * @author CoryZ
 * Amazon home page objects and locators for method steps.
 */

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;


public class GoogleHomeObjects {

	WebDriver driver;
	static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\GoogleReportResults.html", true);;
	static ExtentTest test = report.startTest("ExtentDemo");

	//Constructor
	public GoogleHomeObjects(WebDriver driver) {
		this.driver = driver;
	}

	
	//Locators
	static By txtbox_search = By.xpath("//*[@class = 'gLFyf gsfi' and @type ='text']");
	static By firstResult = By.xpath("//*[@class = 'LC20lb DKV0Md']");

	/**
	 * @author CoryZ
	 * Below are methods for Amazon page navigation
	 */
	
	//Method that sends user input into the Google search bar
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
	
	//Method that will click the first result in a returned Google search
	public void clickResult() {
		driver.findElement(firstResult).click();
	}
	
	//Method to navigate to a new page
	public void navNewPage(String newPage) {
		driver.navigate().to(newPage);
	}
	
	//Method to verify that current url has navigated away from the google home page.
	public void verifyNewPage() {
		String url = driver.getCurrentUrl();
		
		if(url.equals("https://www.google.com/")) {
			test.log(LogStatus.FAIL, "Current url is still Google" );
		}else {
			test.log(LogStatus.PASS, "Url changed");
		}
	}
	
	public void flushTest() {
		report.endTest(test);
		report.flush();
	}

}

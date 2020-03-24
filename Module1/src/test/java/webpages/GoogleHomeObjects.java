package webpages;

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
	static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html", true);;
	static ExtentTest test = report.startTest("ExtentDemo");

	//Constructor
	public GoogleHomeObjects(WebDriver driver) {
		this.driver = driver;
	}

	//Locators
	static By txtbox_search = By.xpath("//*[@class = 'gLFyf gsfi' and @type ='text']");
	static By firstResult = By.xpath("//*[@class = 'LC20lb DKV0Md']");

	//Methods for Google Search
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
	
	public void navNewPage(String newPage) {
		driver.navigate().to(newPage);
	}
	
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

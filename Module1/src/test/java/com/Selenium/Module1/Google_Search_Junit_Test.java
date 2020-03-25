package com.Selenium.Module1;

/**
 * @author CoryZ
 * Test that tests functionality of Google Search bar using Junit annotations.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webpages.GoogleHomeObjects;

public class Google_Search_Junit_Test {

static WebDriver driver;
static GoogleHomeObjects testRun;

	@Before
	public void startUp() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//Set driver to webpage
		driver.get("https://google.com");
		
		//Instantiate GoogleHomeObjects to access locators and methods to perform actions
		testRun = new GoogleHomeObjects(driver);
	}

	@Test
	public void googleSearchTest() {
		//Story lines
		testRun.search("Mordred");
		testRun.returnSearch();
		testRun.search("Lancelot");
		testRun.returnSearch();
		testRun.search("Galahad");
		testRun.returnSearch();
		testRun.clickResult();
		
		//Uncomment below to show failing testcase
		//testRun.navNewPage("https://google.com");
		//testRun.verifyNewPage();
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test is complete");
	}
	
	@AfterClass
	public static void flushReport() {
		testRun.flushTest();
	}
}

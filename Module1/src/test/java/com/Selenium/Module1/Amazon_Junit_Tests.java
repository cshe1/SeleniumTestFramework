package com.Selenium.Module1;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webpages.AmazonHomeObjects;

public class Amazon_Junit_Tests {

	static WebDriver driver;
	static AmazonHomeObjects testRun;

	@Before
	public void startUp() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		//Set driver to webpage
		driver.get("https://amazon.com");

		//Instantiate AmazonHomeObjects to access locators and methods to perform actions
		testRun = new AmazonHomeObjects(driver);
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

	@Test
	public void googleSearchTest() {
		//Story lines
		testRun.search("Necronomicon");
		testRun.returnSearch();
		testRun.search("Persona 5");
		testRun.returnSearch();
		testRun.clickResult();
		//testRun.addToCart();
		testRun.verifyCartNotEmpty();

	}
}

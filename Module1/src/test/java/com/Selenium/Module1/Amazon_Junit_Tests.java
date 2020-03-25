package com.Selenium.Module1;

/**
 * @author CoryZ
 * Test that tests basic functionality of the Amazon search bar and Amazon cart using JUnit annotations. 
 * Test will pass if an item is added successfully to the cart and will fail if no item is added 
 * to the cart.
 */

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
		//Uncomment or Comment below step to pass or fail test
		//testRun.addToCart();
		testRun.verifyCartNotEmpty();

	}
}

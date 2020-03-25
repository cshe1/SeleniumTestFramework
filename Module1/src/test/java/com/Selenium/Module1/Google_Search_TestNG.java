package com.Selenium.Module1;

/**
 * @author CoryZ
 * 
 * Test that tests functionality of the Google Search bar using TestNG annotations
 */

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webpages.GoogleHomeObjects;

public class Google_Search_TestNG {

	static WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//Set driver to webpage
		driver.get("https://google.com");
	}

	@Test
	public static void googleSearchTest() {
		//Instantiate GoogleHomeObjects to access locators and methods to perform actions
		GoogleHomeObjects testRun = new GoogleHomeObjects(driver);
		
		//Story lines
		testRun.search("Mordred");
		
		testRun.returnSearch();
	}
	
	@AfterTest
	public static void endTest() {
		driver.close();
		driver.quit();
		System.out.println("Test is complete");
	}
	
}

package com.Selenium.Module1;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import webpages.GoogleHomeObjects;

public class Google_Search_Test {

	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		googleSearchTest();

	}

	public static void googleSearchTest() {
		//Set driver to get google homepage
		driver.get("https://google.com");

		//Instantiate GoogleHomeObjects to access locators and methods to perform actions
		GoogleHomeObjects testRun = new GoogleHomeObjects(driver);
		
		//Story lines
		testRun.search("Mordred");
		testRun.returnSearch();
		driver.close();
		
	}
}

package com.org.konakart.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ReadExcelData;
import com.org.konakrt.utils.ValidateTestResult;

public class SearchPage extends InvokeBrowser {

	// Click on dropdown
	@Test(priority = 1)
	public void clickOnDropDown() {
		css = read.readPropertiesFile("loc.dropdown.class.css");
		PageActions.clickOnElement(driver, css);
	}

	// select a product from dropdown(Games-call of duty)
	// Providing the data through data provider(

	@Test(priority = 2, dataProvider = "data", dataProviderClass = ReadExcelData.class)
	public void enterData(String[] in) {
		css = read.readPropertiesFile("loc.dropdown.class.css");
		driver.findElement(By.cssSelector(css)).sendKeys(in[0]);
		log.info("Selected the data"); // Click on search
		css = read.readPropertiesFile("loc.serachfield.css");
		driver.findElement(By.cssSelector(css)).sendKeys(in[1]);
		PageActions.clickOnElement(driver, css);
		log.info("selected Call of duty");
	
		// click search button
		css = read.readPropertiesFile("loc.searchbutton.css");
		PageActions.clickOnElement(driver, css);
		log.info("Searching...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void invalidOutcome() {
		css = read.readPropertiesFile("loc.invalidoutcome.css");
		String invalidoutcome = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(invalidoutcome, "msg", "No matches");
		log.info("No results found");
	}

	// validate valid outcome
	@Test(priority = 3)
	public void ValidOutcome() {
		css = read.readPropertiesFile("loc.validoutcome.price.css");
		String validoutcome = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(validoutcome, "price", "No matches");
		log.info("Call of duty");

	}

}

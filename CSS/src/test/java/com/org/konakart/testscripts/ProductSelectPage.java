package com.org.konakart.testscripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ValidateTestResult;



public class ProductSelectPage extends InvokeBrowser {
	SearchPage search = new SearchPage();

	@Test(priority = 2)
	public void selectProductFromDropdown() {
		css = read.readPropertiesFile("loc.select.computerperipherals.css");
		PageActions.clickOnElement(driver, css);
		css = read.readPropertiesFile("loc.hitonsearch.css");
		PageActions.clickOnElement(driver, css);
	}

	@Test(priority = 3)
	public void enterData() {
		css = read.readPropertiesFile("loc.clicktextfield.css");
		driver.findElement(By.cssSelector(css)).sendKeys("graphics cards");
		log.info("Entered as Graphics cards");
	}

	@Test(priority = 4)
	public void hitSearch() {
		css = read.readPropertiesFile("loc.hitonsearch.css");
		PageActions.clickOnElement(driver, css);
	}

	@Test(priority = 5)
	public void validateOutcomeNotByDropdown() {
		css = read.readPropertiesFile("loc.validate.outcome.notselectedfromdropdown.css");
		WebElement outcome = driver.findElement(By.cssSelector(css));
		ValidateTestResult.validateData(outcome, "outcomevalue", "No match found");
	}

	@Test(priority = 6)
	public void enterValue() {
		css = read.readPropertiesFile("loc.clicktextfield.css");
		PageActions.clickOnElement(driver, css);
		driver.findElement(By.cssSelector(css)).sendKeys("graphics cards");
		css = read.readPropertiesFile("loc.selectgraphicscards.css");
		PageActions.clickOnElement(driver, css);
	}

	@Test(priority = 7)
	public void validateOutcomeByDropdown() {
		css = read.readPropertiesFile("loc.noofitems.outcome.css");
		String outcomebydopdown = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(outcomebydopdown, "OutComeBydropdown", "No match");
	}
}

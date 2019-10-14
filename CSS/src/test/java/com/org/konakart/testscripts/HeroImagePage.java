package com.org.konakart.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ValidateTestResult;

public class HeroImagePage extends InvokeBrowser {

	// click on the hero image (used as Westclox 32042r Retro 1950 Kitchen Wall
	// Clock 9.5-inch Red)
	@Test(priority = 2)
	public void clickOnHeroImage() {
		css = read.readPropertiesFile("loc.heroimage.css");
		PageActions.clickOnElement(driver, css);
	}

	@Test(priority = 3)
	public void validatetabsOfHeroImage() {
		if ("loc.title.css" != null) {
			css = read.readPropertiesFile("loc.product.css");
			String kindleproduct = driver.findElement(By.cssSelector(css)).getText();
			validate.validateData(kindleproduct, "product", "No match");
			
			css=read.readPropertiesFile("loc.spec.css");
			String spec=driver.findElement(By.cssSelector(css)).getText();
			validate.validateData(spec, "spec", "No match");
		}
	}

	/*
	 * //Navigation of tabs
	 * 
	 * @Test(priority = 3) public void navigateTabs() { css =
	 * read.readPropertiesFile("loc.navigate.specifications.css");
	 * PageActions.clickOnElement(driver, css);
	 * 
	 * css = read.readPropertiesFile("loc.navigate.customer.css");
	 * PageActions.clickOnElement(driver, css); }
	 * 
	 * //validation of the content of tabs
	 * 
	 * @Test(priority = 4) public void validateContentOfTabs() { css =
	 * read.readPropertiesFile("loc.validatecontent.description.css"); String desc =
	 * driver.findElement(By.cssSelector(css)).getText();
	 * ValidateTestResult.validateData(desc, "description", "No matches");
	 * 
	 * css = read.readPropertiesFile("loc.validatecontent.specifications.css");
	 * String speccontent = driver.findElement(By.cssSelector(css)).getText();
	 * ValidateTestResult.validateData(speccontent, "specvalue", "No matches");
	 * 
	 * css = read.readPropertiesFile("loc.validatecontent.customer.css"); String
	 * customercontent = driver.findElement(By.cssSelector(css)).getText();
	 * ValidateTestResult.validateData(customercontent, "customervalue",
	 * "No matches");
	 * 
	 * css = read.readPropertiesFile("loc.validate.productreviewdate.css"); String
	 * reviewdate = driver.findElement(By.cssSelector(css)).getText();
	 * ValidateTestResult.validateData(reviewdate, "date", "No match");
	 * 
	 * }
	 * 
	 * //validation for sorting by number
	 * 
	 * @Test(priority = 5) public void validateSortByNumber() { // click on the
	 * dropdown css = read.readPropertiesFile("loc.sortbynumber.click.css");
	 * PageActions.clickOnElement(driver, css); //select number from the dropdown
	 * css = read.readPropertiesFile("loc.validate.sortperpage.css");
	 * PageActions.clickOnElement(driver, css); //validation of the number selected
	 * css = read.readPropertiesFile("loc.validate.sortperpage.css"); String perpage
	 * = driver.findElement(By.cssSelector(css)).getText();
	 * ValidateTestResult.validateData(perpage, "numberperpage", "No match"); }
	 * 
	 * //validation for sorting by actions
	 * 
	 * @Test(priority = 6) public void validateSortByActions() { // click on the
	 * dropdown css = read.readPropertiesFile("loc.sortbyaction.click.css");
	 * PageActions.clickOnElement(driver, css); //select action from the dropdown
	 * css = read.readPropertiesFile("loc.validate.sortbyactions.css");
	 * PageActions.clickOnElement(driver, css); //validation of the action selected
	 * css = read.readPropertiesFile("loc.validate.sortbyactions.css"); String
	 * byaction = driver.findElement(By.cssSelector(css)).getText();
	 * ValidateTestResult.validateData(byaction, "sortbyaction", "No match"); }
	 */
}

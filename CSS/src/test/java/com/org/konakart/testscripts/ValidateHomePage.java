package com.org.konakart.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ValidateTestResult;

public class ValidateHomePage extends InvokeBrowser {
	@Test(priority = 2)
	public void validationLogo() {
		css = read.readPropertiesFile("loc.validate.logo.css");
		boolean logoPresent = driver.findElement(By.cssSelector(css)).isDisplayed();
		log.info("Image is present");

	}

	@Test(priority = 3)
	public void validateTitleOfBrowswer() {
		String title = driver.getTitle();
		ValidateTestResult.validateData(title, "Konakart", "No match");
		log.info("Title matches");
	}

	@Test(priority = 4)
	public void validateDropDown() {
		css = read.readPropertiesFile("loc.validate.dropdown.css");
		String dropdown = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(dropdown, "textvalue", "Value not matched");

	}

	@Test(priority = 5)
	public void validateTabsHomePage() {
		// Validation of landing page using url
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.konakart.com/konakart/Welcome.action");
		log.info("Landed into correct page");
		// validation of tabs in homepage using breadcrumbs(dynamic css is used)
		css = read.readPropertiesFile("loc.click.tab.computer.css");
		PageActions.clickOnElement(driver, css);

		css = read.readPropertiesFile("loc.validate.computer.breadcrumb.css");
		String computerbreadcrumb = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(computerbreadcrumb, "ComputerBreadcrumb", "No match");

	}

}

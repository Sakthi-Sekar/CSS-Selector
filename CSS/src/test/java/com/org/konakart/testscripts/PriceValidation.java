package com.org.konakart.testscripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ValidateTestResult;


public class PriceValidation extends InvokeBrowser {
	@Test(priority = 2)
	public void clickOnHeaders() {
		css = read.readPropertiesFile("loc.headers.computerperipherals.css");
		PageActions.clickOnElement(driver, css);
	}

	@Test(priority = 5)
	public static void slider() {
		int x = 10;
		WebElement slider = driver
				.findElement(By.cssSelector(css));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * x) / 10), 0).click();
		move.build().perform();
		System.out.println("Slider moved");
	}

	@Test(priority = 6)
	public static void validateproduct() {
		String actualproduct = driver.findElement(By.cssSelector(css)).getText();
		String expectedproduct = "Bundle Saver";
		ValidateTestResult.validateData(actualproduct, expectedproduct, "actual not equal to expected");
		log.info("Successfully validated product");
	}

}

package com.org.konakrt.utils;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageActions {
	protected static WebDriver driver;
	Actions builder = new Actions(driver);
	String locatorType;
	String css;

	public static void clickOnElement(WebDriver driver, String css) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(2, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				driver.findElement(By.cssSelector(css)).click();
				return true;
			}
		});

		driver.findElement(By.cssSelector(css)).click();

	}

	public void locators(WebDriver driver) {

		switch (locatorType) {
		case "CLASSNAME":

			driver.findElement(By.className("locatorValue")).click();
			break;
		case "CSSSELECTOR":

			driver.findElement(By.cssSelector("locatorValue")).click();
			break;
		case "ID":

			driver.findElement(By.id("locatorValue")).click();
			break;
		case "LINKTEXT":
			driver.findElement(By.linkText("locatorValue")).click();
			break;
		case "NAME":

			driver.findElement(By.name("locatorValue")).click();
			break;
		case "PARTIALLINKTEXT":

			driver.findElement(By.partialLinkText("locatorValue")).click();
			break;
		case "TAGNAME":

			driver.findElement(By.tagName("locatorValue")).click();
			break;
		case "XPATH":

			driver.findElement(By.xpath("locatorValue")).click();
		}
	}

	public void dropDownHandle() {
		WebElement element = driver.findElement(By.cssSelector("CSS"));
		Select oSelect = new Select(driver.findElement(By.cssSelector("CSS")));
	}
}

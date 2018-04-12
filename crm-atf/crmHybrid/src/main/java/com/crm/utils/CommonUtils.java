package com.crm.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	public static WebDriver wd;

	public static void clickButton(String identifiedby, String locator,
			WebDriver wd) {

		if (identifiedby.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();

		}

		else if (identifiedby.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();

		} else if (identifiedby.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();

		} else if (identifiedby.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();

		}
		else if (identifiedby.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();

		}
		
	}

	public static void inserttext(String identifiedby, String locator, WebDriver wd, String value) {

		if (identifiedby.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(value);
		}

		else if (identifiedby.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(value);

		} else if (identifiedby.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(value);

		} else if (identifiedby.equalsIgnoreCase("name")) {
			wd.findElement(By.className(locator)).sendKeys(value);

		}
	}

	public static void clicklink(String identifiedby, String locator,
			WebDriver wd) {

		if (identifiedby.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();
		}

		else if (identifiedby.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();

		}

		else if (identifiedby.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}

		else if (identifiedby.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		} else if (identifiedby.equalsIgnoreCase("name")) {
			wd.findElement(By.className(locator)).click();

		}
	}

	public static void selectDropDownItem(String identifiedBy, String locator, String itemType, String value, WebDriver wd) {
		WebElement element = null;
		if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.className(locator));
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		}

		Select selobj = new Select(element);
		if (itemType.equals("value")) {
			selobj.selectByValue(value);
		} else if (itemType.equals("text")) {
			selobj.selectByVisibleText(value);
		} else if (itemType.equals("index")) {
			selobj.selectByIndex(Integer.parseInt(value));
		}
	}

	public static void waitforelement(String identifiedby, String locator,
			WebDriver wd) {
		if (identifiedby.equalsIgnoreCase("id")) {
			WebDriverWait Wait = new WebDriverWait(wd, 50);

		}
	}

	public static boolean checkIsTextPresent(String verifyText, WebDriver wd) {
		boolean isTextPresent = false;
		isTextPresent = wd.getPageSource().contains(verifyText);
		return isTextPresent;

	}

	public static void closeAlert(WebDriver wd) {

		if (wd.switchTo().alert() != null) {
			Alert alert = wd.switchTo().alert();
			alert.accept();
		}
	}

	public static void pressEnter(String identifiedBy, String locator,
			String value, WebDriver wd)

	{
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(Keys.ENTER);
		}

		else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
		}
	}

	public static String getText(String identifiedBy, String locator,
			WebDriver wd) {

		if (identifiedBy.equalsIgnoreCase("id")) {
			return wd.findElement(By.id(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			return wd.findElement(By.name(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			return wd.findElement(By.xpath(locator)).getText();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			return wd.findElement(By.cssSelector(locator)).getText();
		}
		return null;
	}

	public static void switchToFrames(String identifiedBy, String locator,
			WebDriver wd) {
		WebElement element = null;

		if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		}
		wd.switchTo().frame(element);
	}

	public static void radiobutton(String identifiedBy, String locator,
			WebDriver wd) {

		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
	}

	public static void refresh(WebDriver wd) {
		wd.navigate().refresh();
	}

	public static void navigateForward(WebDriver wd) {
		wd.navigate().forward();
	}

	public static void navigateBackward(WebDriver wd) {
		wd.navigate().back();
	}

	public static void scrollup(WebDriver wd, int index) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollTo(0, -index)");
	}

	public static void scrolldown(WebDriver wd, int index) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollTo(0, index)");
	}

	public static void upArrow(String identifiedBy, String locator, WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(Keys.ARROW_UP);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(Keys.ARROW_UP);
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(Keys.ARROW_UP);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(Keys.ARROW_UP);
		}
	}

	public static void downArrow(String identifiedBy, String locator,
			WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(Keys.ARROW_DOWN);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(Keys.ARROW_DOWN);
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(Keys.ARROW_DOWN);
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(Keys.ARROW_DOWN);
		}
	}

	public static void clickRadioButton(String identifiedBy, String locator,
			WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}

		else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}

		else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
	}

	public static void mouseHover(String identifiedBy, String locator,
			WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			WebElement element = wd.findElement(By.id("locator"));

			Actions action = new Actions(wd);
			action.moveToElement(element).perform();
		}
		if (identifiedBy.equalsIgnoreCase("css")) {
			WebElement element = wd.findElement(By.cssSelector("locator"));

			Actions action = new Actions(wd);
			action.moveToElement(element).perform();
		}
		if (identifiedBy.equalsIgnoreCase("name")) {
			WebElement element = wd.findElement(By.name("locator"));

			Actions action = new Actions(wd);
			action.moveToElement(element).perform();
		}
		if (identifiedBy.equalsIgnoreCase("xpath")) {
			WebElement element = wd.findElement(By.xpath("locator"));

			Actions action = new Actions(wd);
			action.moveToElement(element).perform();
		}
	}

	public static void selectTheCheckBox(String identifiedBy, String locator,
			WebDriver wd) {

		if (identifiedBy.equalsIgnoreCase("id")) {
			WebElement checkBoxElement = wd.findElement(By.id("locator"));
			checkBoxElement.click();
		}
		if (identifiedBy.equalsIgnoreCase("css")) {
			WebElement checkBoxElement = wd.findElement(By
					.cssSelector("locator"));
			checkBoxElement.click();
		}
		if (identifiedBy.equalsIgnoreCase("name")) {
			WebElement checkBoxElement = wd.findElement(By.name("locator"));
			checkBoxElement.click();
		}
		if (identifiedBy.equalsIgnoreCase("xpath")) {
			WebElement checkBoxElement = wd.findElement(By.xpath("locator"));
			checkBoxElement.click();
		}
	}

	public static void clearText(String identifiedBy, String locator,
			WebDriver wd) {
		if (identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).clear();

		}

		else if (identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).clear();

		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).clear();

		} else if (identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.className(locator)).clear();

		}

	}

	public static void DragAndDrop(WebElement srcElement,
			WebElement dstElement, WebDriver wd) {
		Actions action = new Actions(wd);
		action.dragAndDrop(srcElement, dstElement).perform();
	}

	public static void doubleClick(String identifiedBy, String locator,
			WebDriver wd) {
		Actions action = new Actions(wd);

		if (identifiedBy.equalsIgnoreCase("id")) {
			WebElement element = wd.findElement(By.id(locator));
			action.doubleClick(element).perform();
		}

		if (identifiedBy.equalsIgnoreCase("css")) {
			WebElement element = wd.findElement(By.cssSelector(locator));
			action.doubleClick(element).perform();
		}
		if (identifiedBy.equalsIgnoreCase("name")) {
			WebElement element = wd.findElement(By.name(locator));
			action.doubleClick(element).perform();
		}
		if (identifiedBy.equalsIgnoreCase("xpath")) {
			WebElement element = wd.findElement(By.xpath(locator));
			action.doubleClick(element).perform();
		}
	}
	
	public static void wait(int timeout) throws InterruptedException{
		int timeoutVal = timeout * 1;
		for(int second = 0; second < timeoutVal; second++){
			Thread.sleep(1000);
		}
	} 

	public static boolean isElementPresent(String identifiedBy, String locator,			WebDriver wd) {
		WebElement element = null;
		boolean elementavailable = true;
		if (identifiedBy.equalsIgnoreCase("css")) {
			try {
				element = wd.findElement(By.cssSelector(locator));
			} catch (Exception e) {
				elementavailable = false;
				e.printStackTrace();
			}
		}
		return elementavailable;

	}

	public static void takeScreenShot(WebDriver wd){
		try{
			int count = 0;
			String newFileNamePath;
			File directory = new File(".");
			DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
			Date date = new Date();
			
			newFileNamePath = directory.getCanonicalPath()+"\\ScreenShots\\" + dateformat.format(date)+ "_" + ".png";
			BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(968, 1009));
			
			File file = new File(newFileNamePath);
			ImageIO.write(screencapture, "png", file);
			count ++;
			File screenshot = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(newFileNamePath));
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getItemsFromList(String string, String property, WebDriver wd2) {
		
		return null;
	}
		
	}


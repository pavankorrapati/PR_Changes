package com.adactin.libraries;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MethodImplementations extends Locators {
	static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver",
				"C:\\Users\\venka\\OneDrive\\Documents\\Testing\\Versions\\chrome-version-138");
		driver = new ChromeDriver();
		driver.get(adactinURL);
		System.out.println(driver.getTitle());
		Assert.assertEquals("Adactin.com - Hotel Reservation System", "Adactin.com - Hotel Reservation System");
		Reporter.log("Passed");
	}

	@Test(dependsOnMethods = "launchBrowser")
	public void loginWithValidCred() {
		driver.findElement(username).sendKeys(credUser);
		driver.findElement(password).sendKeys(validCredPass);
		driver.findElement(loginBtn).click();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Adactin.com - Search Hotel", "Adactin.com - Search Hotel");
	}

	@Test(dependsOnMethods = "launchBrowser")
	public void loginWithInvalidValidCred() {
		driver.findElement(username).sendKeys(credUser);
		driver.findElement(password).sendKeys(credPass);
		driver.findElement(loginBtn).click();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Adactin.com - Hotel Reservation System", "Adactin.com - Hotel Reservation System");
	}

	@Test(dependsOnMethods = { "loginWithValidCred" })
	public void logOut() {
		driver.findElement(logOut).click();
		System.out.println(driver.getTitle());
	}

	@Test(dependsOnMethods = { "loginWithInvalidValidCred", "loginWithValidCred" })
	public void tearDown() {
		driver.close();
		// driver.quit();
	}

	@AfterTest
	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void clickItenerary() {
		driver.findElement(By.linkText("Booked Itinerary")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement BB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_all")));
	}

	public List<WebElement> clickCheckBoxes() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@name=\"ids[]\"]"));
		System.out.println(checkBoxes.toString());
		System.out.println(checkBoxes.size());
		return checkBoxes;

//	for(WebElement checkBox:checkBoxes) {
//		checkBox.click();
//		System.out.println(checkBox.isSelected());
//		assert checkBox.isSelected();
//	}
	}

	public void clickBoxes(List<WebElement> checkBoxes) {
		for (WebElement box : checkBoxes) {
			box.click();
			Assert.assertTrue(box.isSelected(), "Check Box is clicked");
		}

	}

	public void clickBoxesRequired(List<WebElement> checkBoxes) {
		int box = checkBoxes.size();
		for (int i = box - 5; i < box; i++) {
			WebElement clickBox = checkBoxes.get(i);
			clickBox.click();
			Assert.assertTrue(clickBox.isSelected(), "Check Box clicked");
		}
	}

	public void clickBoxFromLast() {

		List<WebElement> checkToBeClick = driver.findElements(By.xpath("//*[@name='ids[]']"));
//	for(WebElement check:checkToBeClick) {
//		check.click();
//	}

		for (int i = checkToBeClick.size() - 3; i < checkToBeClick.size(); i++) {
			checkToBeClick.get(i).click();
		}
	}

	public void selectHotelDropDownOptions() {

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dropdown = driver.findElement(By.id("location"));
		System.out.println(dropdown);

		Select drop1 = new Select(dropdown);
		
		System.out.println(drop1.getOptions().toString());

		List<WebElement> option = drop1.getOptions();
		for (WebElement opt : option) {
			String str = opt.getText();
			System.out.println(str);
			if (str.equals("Adelaide")) {
				drop1.selectByValue(str);
			}
		}

	}

	public void verifyLinksFunctioanlity() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		int broken = 0;
		int live = 0;
		for (WebElement link : links) {

			String linkName = link.getText();
			String url = link.getAttribute("href");
			// System.out.println(linkName+": "+url);
			if (url == null || url.isEmpty()) {
				System.out.println("No url defined for the " + link);
				continue;
			}

			try {

				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();

				int responseCode = connection.getResponseCode();
				if (responseCode >= 200 && responseCode < 300) {
					System.out.println(linkName + ":::" + url + ": is working fine");
					live++;
				} else {
					System.out.println(linkName + ":::" + url + ": is broken");
					broken++;
				}

				connection.disconnect();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Live connections are: " + live);
		System.out.println("Broken connections are: " + broken);
	}

}

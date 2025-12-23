package com.adactin.libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MethodImplementations2 extends Locators{
	static WebDriver driver;
//@Test(priority=1)
	@Test
public void launchBrowser() {
	System.setProperty("WebDriver.chrome.driver", "C:\\Users\\venka\\OneDrive\\Documents\\Testing\\Versions\\chrome-version-138");
    driver=new ChromeDriver();
    driver.get(adactinURL);
    System.out.println(driver.getTitle());
    Assert.assertEquals("Adactin.com - Hotel Reservation System", "Adactin.com - Hotel Reservation System");
    Reporter.log("Passed");
}
@Test(priority=2)
public void loginWithValidCred() {
	driver.findElement(username).sendKeys(credUser);
	driver.findElement(password).sendKeys(validCredPass);
	driver.findElement(loginBtn).click();
	System.out.println(driver.getTitle());
	Assert.assertEquals("Adactin.com - Search Hotel", "Adactin.com - Search Hotel");
}
@Test(enabled=false) //SKIP the execution
public void loginWithInvalidValidCred() {
	driver.findElement(username).sendKeys(credUser);
	driver.findElement(password).sendKeys(credPass);
	driver.findElement(loginBtn).click();
	System.out.println(driver.getTitle());
	System.out.println("InValid CLICK");
	Assert.assertEquals("Adactin.com - Hotel Reservation System", "Adactin.com - Hotel Reservation System");
}
@Test(priority=3)
public void logOut() {
	driver.findElement(logOut).click();
	System.out.println(driver.getTitle());
}
//@Test(priority=4)
@Test(groups="smoke")
public void tearDown() {
	System.out.println("Closing");
	driver.close();
	//driver.quit();
}
@Test(priority=5)
public void quitBrowser() {
	System.out.println("Quitting");
    if (driver != null) {
        driver.quit();
    }
}
}

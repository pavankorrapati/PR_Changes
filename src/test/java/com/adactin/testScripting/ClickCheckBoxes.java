package com.adactin.testScripting;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.adactin.libraries.MethodImplementations;

public class ClickCheckBoxes extends MethodImplementations{
public static void main(String[] args) throws Exception {
	ClickCheckBoxes driver= new ClickCheckBoxes();
	driver.launchBrowser();
	driver.loginWithValidCred();
	driver.clickItenerary();
	driver.clickBoxFromLast();
	Thread.sleep(3000);
	driver.clickBoxFromLast();
	//List<WebElement> element=driver.clickCheckBoxes();
	//driver.clickBoxes(element);
	//driver.clickBoxesRequired(element);
	
}
}

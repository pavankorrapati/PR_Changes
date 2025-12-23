package com.adactin.testScripting;

import com.adactin.libraries.MethodImplementations;

public class DropDownOptions extends MethodImplementations{
public static void main(String[] args) {
	DropDownOptions driver = new DropDownOptions();
	driver.launchBrowser();
	driver.loginWithValidCred();
	driver.selectHotelDropDownOptions();
}
}

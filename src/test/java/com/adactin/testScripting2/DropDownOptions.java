package com.adactin.testScripting2;

import com.adactin.libraries.MethodImplementations;

public class DropDownOptions extends MethodImplementations{
public static void main(String[] args) {
	DropDownOptions driver = new DropDownOptions();
	driver.launchBrowser();
	driver.loginWithValidCred();
	driver.selectHotelDropDownOptions();
}
}

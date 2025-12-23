package com.adactin.libraries1;

import org.openqa.selenium.By;

public class Locators {
	//URL
	static String adactinURL="https://adactinhotelapp.com/";
	
	//Test Data
	String credUser="pavan230";
	String credPass="chandini";
	String validCredPass="211J9A";
	
	//Locators
	By username=By.id("username");
	By password=By.id("password");
	By loginBtn=By.id("login");
	By logOut=By.linkText("Logout");
	
	
	
}

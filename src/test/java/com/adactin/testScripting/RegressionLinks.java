package com.adactin.testScripting;

import com.adactin.libraries.MethodImplementations;

public class RegressionLinks extends MethodImplementations{
public static void main(String[] args) {
	RegressionLinks driver= new RegressionLinks();
	driver.launchBrowser();
	driver.loginWithValidCred();
	driver.verifyLinksFunctioanlity();
	
}
}

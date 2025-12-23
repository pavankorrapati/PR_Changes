package com.adactin.testScripting;


import org.testng.annotations.Test;

import com.adactin.libraries.MethodImplementations;


public class TC001_Login extends MethodImplementations{
    @Test(priority=2)
	public void login() {
//	1. Launch browser
//	2. Login into application with valid credentials
//	3. Logout application
//	4. Close browser
	
	TC001_Login test=new TC001_Login();
	
	
	test.launchBrowser();
	test.loginWithValidCred();
	//test.logOut();
	test.tearDown();
	
}
}

package com.adactin.testScripting;


import org.testng.annotations.Test;

import com.adactin.libraries.MethodImplementations;


public class TC001_Login2 extends MethodImplementations{
    @Test(priority=1)
	public void login2() {
//	1. Launch browser
//	2. Login into application with valid credentials
//	3. Logout application
//	4. Close browser
	
	TC001_Login2 test=new TC001_Login2();
	
	
	test.launchBrowser();
	test.loginWithInvalidValidCred();
	test.logOut();
	//test.tearDown();
	
}
}

package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LogIn_Page;

public class TC_LogIn_001 extends Base_Class {

	
	@Test
	public void logInTest() throws IOException {
		
		LogIn_Page lp= new LogIn_Page(driver);
		
		lp.setUserName(username);
		logger.info("Enter username");
		
		lp.setPassword(password);
		logger.info("enter password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("LogIn test passed");
		}
		else
		{
			captureScreenShot(driver, "logInTest");
			Assert.assertFalse(false);
			logger.info("LogIn test failed");
		}
	}
}

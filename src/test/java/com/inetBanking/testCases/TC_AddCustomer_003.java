package com.inetBanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.AddCustomer_Page;
import com.inetBanking.pageObjects.LogIn_Page;

public class TC_AddCustomer_003 extends Base_Class
{

	@Test
	public void addCustomerTest() throws InterruptedException, IOException
	{
		LogIn_Page lp=new LogIn_Page(driver);
		
		lp.setUserName(username);
		logger.info("username provided");
		
		lp.setPassword(password);
		logger.info("password provided");
		
		lp.clickSubmit();
	    
		
		AddCustomer_Page acp=new AddCustomer_Page(driver);
		logger.info("Providing customer details..");
		
		 acp.addCustomer();
		 Thread.sleep(3000);
		 acp.customerName("Manisha");
		 acp.gender("female");
		 acp.selectDOB("23", "08", "1990");
		 acp.enterAddress("BLR");
		 acp.addCity("BLR");
		 acp.addState("Karnatak");
		 acp.addPin("560033");
		
		 String phoneNo= randomNum();
		 acp.addPhoneNo(phoneNo);
		
		 String email= Randomstring()+"@gmail.com";
		 acp.addEmailID(email);
		
         acp.setPassword("nisa12345");
		 acp.clicksubmit();
		 
		 Thread.sleep(2000);
		 
		 logger.info("validation started...");
		 boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		 
		 if(res== true)
		 {
			 Assert.assertTrue(true);
			 logger.info("Test is passed");
		 }
		 else
		 {
			 captureScreenShot(driver,"AddNewCustomer");
			 Assert.assertTrue(false);
			 logger.warn("Test is failed");
		 }
		
		 
	}

	

	
	}

	





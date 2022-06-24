package com.inetBanking.testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import com.inetBanking.pageObjects.LogIn_Page;
import com.inetBanking.utilities.XLUtils;

public class TC_DDT_002 extends Base_Class {
	
	@Test(dataProvider="LogInData")
	public void LogInDDT(String uname, String pwd) throws InterruptedException
	{
		LogIn_Page lp=new LogIn_Page(driver);
		
		lp.setUserName(uname);
		logger.info("Enter username");
		
		lp.setPassword(pwd);
		logger.info("enter password");
		
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
		
			lp.clickLogout();
		    Thread.sleep(2000);
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
    }
	
	public boolean isAlertPresent()    
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
		return false;
		}
	}
	
	@DataProvider(name="LogInData")
    String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/Automation.xlsx";
				
		
		int rowcount= XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rowcount][colcount];
		 
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<colcount; j++)
			{
			   loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i,j);
		
			}
		}
		return loginData;
	}
	
}

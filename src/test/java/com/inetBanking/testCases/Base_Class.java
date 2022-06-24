package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class Base_Class {
	
	ReadConfig config= new ReadConfig();
	
	public String baseUrl= config.getApplicationUrl();
	public String username=config.getUsername();
	public String password=config.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br)
	{
	    logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", config.getChormepath());
			driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", config.getfirefoxpath());
			driver= new FirefoxDriver();
	    }
		else if (br.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver", config.getEdgepath());
			driver= new EdgeDriver();
		}
		
		driver.get(baseUrl);
		logger.info("url is opened");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}
	 
   public void captureScreenShot(WebDriver driver, String tname) throws IOException	
   {
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   File src= ts.getScreenshotAs(OutputType.FILE);
	   File trg= new File(System.getProperty("user.dir") + "/Screenshots/" +tname+ ".png");
	   FileUtils.copyFile(src, trg);
	   System.out.println("Screenshot taken");
 
  }
   public String Randomstring() {
	  String emailIDcreated= RandomStringUtils.randomAlphabetic(10);
		return(emailIDcreated);
	}
  
   public String randomNum() {
	  String phoneno= RandomStringUtils.randomNumeric(9);
	    return(phoneno);
	}
	
}


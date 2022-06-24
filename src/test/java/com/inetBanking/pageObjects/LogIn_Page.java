package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page {
	
	WebDriver ldriver;
	
	public LogIn_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogIn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement btnLogOut;  
	
	public void setUserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogIn.click();
	}
	public void clickLogout() {
		btnLogOut.click();
	}

	
		
	}  
		
	
		


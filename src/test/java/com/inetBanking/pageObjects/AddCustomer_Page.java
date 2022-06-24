package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer_Page {

  WebDriver ldriver;
	
	public AddCustomer_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement NewCustomer;
	
	@FindBy(name="name")
	WebElement CustomerName;
	
	@FindBy(name="rad1")
	WebElement Gender;
	
	@FindBy(name="dob")
	WebElement DateofBirth;
	
	@FindBy(name="addr")
	WebElement Address;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="state")
	WebElement State;
	
	@FindBy(name="pinno")
	WebElement PIN;
	
	@FindBy(name="telephoneno")
	WebElement MobileNumber;
	
	@FindBy(name="emailid")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="sub")
	WebElement Submit;
	
	public void addCustomer() {
		NewCustomer.click();
	}
	public void customerName(String cname) {
		CustomerName.sendKeys(cname);
	}
	public void gender(String gender) {
		Gender.click();
	}
	public void selectDOB(String dd, String mm, String yyyy){
		DateofBirth.sendKeys(dd);
		DateofBirth.sendKeys(mm);
		DateofBirth.sendKeys(yyyy);
	}
	public void enterAddress(String caddress) {
		Address.sendKeys(caddress);
	}
	public void addCity(String cityname) {
		City.sendKeys(cityname);
	}
	public void addState(String cstate) {
		State.sendKeys(cstate);
	}
	public void addPin(String pinno) {    
		PIN.sendKeys(String.valueOf(pinno)); 
	}
	public void addPhoneNo(String cphoneno) {
		MobileNumber.sendKeys(cphoneno);
	}
	public void addEmailID(String emailid) {
		Email.sendKeys(emailid);
	}
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	public void clicksubmit() {
		Submit.click();
	}
}

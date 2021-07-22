package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{

WebDriver driver;

public  LoginPage(WebDriver driver1) 
{
	this.driver=driver1;
}

@FindBy(name="username") WebElement uname;


@FindBy(name="password") WebElement pass;


@FindBy(css =".btn.btn-small") WebElement loginButton;


public  void loginApplication(String UsernameApp,String PassApplication)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	uname.sendKeys(UsernameApp);
	pass.sendKeys(PassApplication);
	loginButton.click();
}
	
}

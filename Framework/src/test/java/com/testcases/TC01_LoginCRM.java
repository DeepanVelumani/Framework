package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utility.BrowserFactory;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class TC01_LoginCRM extends BaseClass{

	

	@Test
	public void loginCRM()
	{
		logger = report.createTest("Login to CRM");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Test Started");

		login.loginApplication(excel.getStringData("LoginPage", 0, 0), excel.getStringData("LoginPage", 0, 1));	
		
		logger.pass("Test Pass");

		
		
	}

}

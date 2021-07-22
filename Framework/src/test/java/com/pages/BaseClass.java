package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void startUpSuite()
	{
		Reporter.log("System Setting up", true);
		
		excel =new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_" +Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("System Setting up done", true);
	
	}
	
	@BeforeClass
	public void startUp() 
	{
		Reporter.log("Launching the Browser", true);
		
		driver = BrowserFactory.StartBrowser(driver, config.getBrowser(), config.getTestURL());
		
		Reporter.log("Browser launc is Succesful", true);

	}

	@AfterClass
	public void tearDown() 
	{
		Reporter.log("Trying to close the Browser", true);
		
		BrowserFactory.quitBrowser(driver);
		
		Reporter.log("Browser Closed Succesfully", true);
	}
	
	@AfterMethod
	public void tearDowmMethod(ITestResult Result) throws IOException
	{
		Reporter.log("Extent Reports are starting to generate", true);
		
		if (Result.getStatus()==ITestResult.FAILURE) 
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());
		}
		else if (Result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());
		}
		report.flush();
		
		Reporter.log("Take Screenshot ---> Reort generated", true);
	}

}

package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
    WebDriver driver;
    
	public static WebDriver StartBrowser(WebDriver driver,String browserName,String URL)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91978\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			
			 driver=new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					"./Drivers\\geckodriver.exe");
			
			 driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver",
					"./Drivers\\IEDriverServer.exe");
			
			 driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please Enter the Valid Browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}

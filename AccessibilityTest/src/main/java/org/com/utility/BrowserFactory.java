package org.com.utility;

import java.util.concurrent.TimeUnit;

import org.com.runner.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends BaseClass{
	public WebDriver launchBrowser(String browser)
	{
		int ID=(int) Thread.currentThread().getId();
		try
		{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			BrowserVersion=WebDriverManager.chromedriver().getDownloadedDriverVersion();
			System.out.println("Browser Version = "+BrowserVersion);
			
			ChromeOptions chromeOptions=new ChromeOptions(); 
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--no-sandbox","--disable-dev-shm-usage","disable-inforbars","--enable-automation","--false-useAutomationExtension");
		
			driver.set(new ChromeDriver(chromeOptions));
			
			driver.get().manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.get().manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			driver.get().manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getWebDriver();
	}
}

package org.com.step;

import java.io.IOException;
import java.util.List;

import org.com.runner.BaseClass;
import org.com.utility.CheckAccessibility;

import com.deque.html.axecore.results.Results;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccessibilityTesting_Step extends BaseClass{
	public Results passResult;
	@Given("Launch the {string} and navigate to {string} to validate the Conformance Tag {string}")
	public void launchTheBrowser(String browser, String url,String conformanceTag )
	{
		try{
			Browser = browser;
			ConformanceLevel = conformanceTag;
			browserFactory.launchBrowser(browser);
			navigateTo(url);
			Thread.sleep(5000);
			checkAccessibility=new CheckAccessibility(getWebDriver());
			passResult=checkAccessibility.PrepareResult(conformanceTag);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Then("find and print the number of passed items at {string}")
	public void findPassedItems(String resultPath) throws IOException
	{
//		checkAccessibility=new CheckAccessibility(getWebDriver());		
		checkAccessibility.findAndPrintResult(passResult, resultPath, "passed");

		//		checkAccessibility.findAndPrintPasses(ConformanceLevel,resultPath);
	}

	@Then("find and print the number of violation items at {string}")
	public void findViolationItems(String resultPath) throws IOException
	{
//		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintResult(passResult, resultPath, "violation");


		//		checkAccessibility.findAndPrintViolations(ConformanceLevel,resultPath);
	}

	@Then("find and print the number of review items at {string}")
	public void findIncompleteItems(String resultPath) throws IOException 
	{
//		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintResult(passResult, resultPath, "incomplete");

		//		
		//		checkAccessibility.findAndPrintReviews(ConformanceLevel,resultPath);
	}

	@Then("find and print the number of inapplicable items at {string}")
	public void findInapplicableItems(String resultPath) throws IOException
	{
//		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintResult(passResult, resultPath, "inapplicable");

		//		checkAccessibility.findAndPrintInapplicable(ConformanceLevel,resultPath);
	}

}

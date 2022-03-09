package org.com.runner;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features="src//main//resources//featureFiles",
				tags= "@AxeTest",
				dryRun=false,
				glue="org.com.step",
				plugin= {"pretty","html:test-output/cucumber-reports/cucumber.html","json:test-output/cucumber-reports/cucumber.json"},
				monochrome=true)

public class TestRunner implements ITest
{
	private TestNGCucumberRunner testNGCucumberRunner;
	private static BaseClass baseClass;
	private ThreadLocal<String> testName=new ThreadLocal<String>();
	public String executionStartTime;
	@Override
	public String getTestName()
	{
		return testName.get();
	}
	
	@BeforeClass(alwaysRun=false)
	public void beforeClass()
	{
		baseClass=new BaseClass();
		//baseClass.initBeforeClass();
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		//BasicConfigurator.configure();
		executionStartTime = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss").format(new Date());
		
	}
	
	@AfterClass
	public void tearDown()
	{
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		
		testNGCucumberRunner.finish();
		//baseClass.quitBrowsers();
		
		String executionEndTime = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss").format(new Date());
		System.out.println("Execution Start time : " + executionStartTime);
		System.out.println("Execution End time : " + executionEndTime);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method,Object[] testData)
	{
		String testname=testData[0].toString();
		testName.set(testname);
	}
	
	@Test(groups="cucumber scenarios",dataProvider="scenarios")
	public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable
	{
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}
	
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		return testNGCucumberRunner.provideScenarios();
	}
}
